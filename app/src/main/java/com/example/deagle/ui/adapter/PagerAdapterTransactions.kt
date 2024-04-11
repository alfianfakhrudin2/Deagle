package com.example.deagle.ui.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.deagle.ui.transactions.BelumBayarFragment
import com.example.deagle.ui.transactions.SudahBayarFragment
import com.example.deagle.ui.transactions.TransactionsFragment

class PagerAdapterTransactions (Activity: TransactionsFragment) : FragmentStateAdapter(Activity){
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = SudahBayarFragment()
            1 -> fragment = BelumBayarFragment()
        }
        return fragment as Fragment
    }
}