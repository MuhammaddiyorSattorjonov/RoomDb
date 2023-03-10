    package com.example.roomdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.Toast
import com.example.roomdb.adapter.RvAdapter
import com.example.roomdb.databinding.ActivityMainBinding
import com.example.roomdb.db.AppDataBase
import com.example.roomdb.models.MyPerson

    class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater)}
    private lateinit var appDataBase: AppDataBase
    private lateinit var adapter: RvAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        appDataBase = AppDataBase.getInstance(this)
        adapter = RvAdapter(appDataBase.myDao().getAllPerson() as ArrayList)
        binding.rv.adapter = adapter

        binding.apply {
            binding.btn.setOnClickListener{
                val myPerson = MyPerson(binding.name.text.toString(),binding.number.text.toString())
                appDataBase.myDao().addPerson(myPerson)
                adapter.list.add(myPerson)
                adapter.notifyItemInserted(adapter.list.size-1)
                Toast.makeText(this@MainActivity, "Saved", Toast.LENGTH_SHORT).show()
            }
        }
    }
}