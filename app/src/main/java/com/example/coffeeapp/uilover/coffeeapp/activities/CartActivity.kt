package com.example.coffeeapp.uilover.coffeeapp.activities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coffeeapp.R
import com.example.coffeeapp.databinding.ActivityCartBinding
import com.example.coffeeapp.uilover.coffeeapp.Helper.ChangeNumberItemsListener
import com.example.coffeeapp.uilover.coffeeapp.Helper.ManagmentCart
import com.example.coffeeapp.uilover.coffeeapp.adapter.CartAdapter

class CartActivity : AppCompatActivity() {
    lateinit var  binding: ActivityCartBinding
    lateinit var managmentCart: ManagmentCart
    private  var tax: Double = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding= ActivityCartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        managmentCart = ManagmentCart(this)

        calculatoCart()
        setVariable()
        initCartList()

    }

    private fun initCartList() {
        binding.apply {
            listView.layoutManager=
                LinearLayoutManager(this@CartActivity, LinearLayoutManager.VERTICAL,false)
            listView.adapter = CartAdapter(
                managmentCart.getListCart(),
                this@CartActivity,
                object : ChangeNumberItemsListener{
                    override fun onChanged() {
                        calculatoCart()
                    }

                }
            )
        }
    }

    private fun setVariable() {
        binding.backBtn.setOnClickListener { finish() }
    }

    private fun calculatoCart() {
        val percentTax = 0.01
        val delivery = 1.5
        tax=((managmentCart.getTotalFee()*percentTax)*100)/100.0
        val total = ((managmentCart.getTotalFee()+tax+delivery)*100)/100
        val itemTotal = (managmentCart.getTotalFee()*100)/100

        binding.apply {
            totalFeeTxt.text = "$$itemTotal"
            totalTaxTxt.text = "$$tax"
            deliveryTxt.text = "$$delivery"
            totalTxt.text = "$$total"
        }
    }


}