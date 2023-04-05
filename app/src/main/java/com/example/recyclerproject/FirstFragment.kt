package com.example.myfragment

import android.app.DatePickerDialog
import android.os.Bundle
import android.os.Message
import android.text.Editable
import android.text.TextWatcher
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.lifecycle.ViewModelProviders
import com.example.recyclerproject.*
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*


class FirstFragment : Fragment() {

    private var communicationViewModel: CommunicationViewModel? = null

    private var db: AppDataBase? = null
    private var userDao: UserDao? = null

    private var namaInput: String = ""
    private var emailInput: String = ""
    private var dateInput: String = ""

    private var edtName: EditText? = null
    private var edtEmail: EditText? = null
    private var edtDate: Button? = null

    private var btnSave: Button? = null
    lateinit var pickDateButton : Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        communicationViewModel = ViewModelProviders.of(requireActivity()).get(CommunicationViewModel::class.java)

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first,
            container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initLocalDB()
        initView()
        val ShowPass = view.findViewById<CheckBox>(R.id.showpass)
        val pass = view.findViewById<TextInputEditText>(R.id.textInputTextPass)

        ShowPass.setOnClickListener {
            if (ShowPass.isChecked) {
                pass.transformationMethod = HideReturnsTransformationMethod.getInstance()
            } else {
                pass.transformationMethod = PasswordTransformationMethod.getInstance()
            }
        }

//        Date
        pickDateButton = view.findViewById(R.id.idBtnPickDate)

        pickDateButton.setOnClickListener {
            val c = Calendar.getInstance()

            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(
                requireActivity(),
                { view, year, monthOfYear, dayOfMonth ->
                    pickDateButton.text =
                        (dayOfMonth.toString() + "\t-\t" + (monthOfYear + 1) + "\t-\t" + year)
                },
                year,
                month,
                day
            )
            datePickerDialog.show()
        }
    }
    private fun initLocalDB() {
        db = AppDataBase.getAppDatabase(requireActivity())
        userDao = db?.userDao()

    }
    private fun initView() {
        edtName = activity?.findViewById(R.id.textInputTextName)
        edtDate = activity?.findViewById(R.id.idBtnPickDate)
        edtEmail = activity?.findViewById(R.id.textInputTextEmail)
        btnSave = activity?.findViewById(R.id.btnSave)
        btnSave?.setOnClickListener {
            validasiInput()
        }
    }

    private fun validasiInput(){
        namaInput = edtName?.text.toString()
        emailInput = edtEmail?.text.toString()
        dateInput = edtDate?.text.toString()



        when {
            namaInput.isEmpty() -> edtName?.error = "Nama tidak bolehkosong"
            emailInput.isEmpty() -> edtEmail?.error = "Email tidak boleh kosong"
            dateInput.isEmpty() -> edtDate?.error = "Tanggal tidak boleh kosong"

            else ->{
                val userr = User(
                    nama = namaInput,
                    email = emailInput,
                    date = dateInput
                )
                tambahDataUser(userr)
                Toast.makeText(requireActivity(), "Data Di Simpan", Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun tambahDataUser(userr: User) : Job{
        return GlobalScope.launch {
            userDao?.tambahUser(userr)
        }
    }




    companion object {
        fun newInstance(): FirstFragment{
            return FirstFragment()
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        db?.close()
        edtName = null
        edtEmail = null
        edtDate = null

    }
}