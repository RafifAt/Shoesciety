package com.example.myfragment

import android.os.Bundle
import android.os.Message
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerproject.*


class SecondFragment : Fragment() {
    // TODO: Rename and change types of parameters

    private var comModel: CommunicationViewModel? = null
    private var listMyUser: RecyclerView? = null
    private var listUser : kotlin.collections.List<User>? = null
    private var db: AppDataBase? = null
    private var userDao : UserDao? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        comModel = ViewModelProviders.of(requireActivity()).get(CommunicationViewModel::class.java)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initLocalDB()
        initView()
    }

    private fun initView() {
        listMyUser = activity?.findViewById(R.id.listMyData)
        ambilDataUser()
    }

    private fun initLocalDB(){
        db = AppDataBase.getAppDatabase(requireActivity())
        userDao = db?.userDao()
    }
   private fun ambilDataUser (){
       listUser = ArrayList()
       userDao?.ambilSemuaUser()?.observe(this, Observer { r -> listUser = r
           when{
               listUser?.size == 0 -> tampilToast("Belum")

               else ->{
                   tampilUser()
               }
           }
       })
   }
    private fun tampilUser(){
        listMyUser?.layoutManager = LinearLayoutManager(activity)
        listMyUser?.adapter = Adapter(requireActivity(),listUser!! as ArrayList<User>)
    }
    private fun tampilToast(message: String){
        Toast.makeText(requireActivity(), message, Toast.LENGTH_SHORT).show()
    }

    companion object {
        fun newInstance():SecondFragment{
            return SecondFragment()
        }
    }

}