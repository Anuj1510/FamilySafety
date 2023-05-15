package com.example.familysafety

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class HomeFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val listMembers = listOf<MemberModal>(
            MemberModal("Lokesh Kumar","F-204 Delta 1 Greater Noida","70","50 km"),
            MemberModal("Anuj Shahi","F-204 Delta 1 Greater Noida","70","50 km"),
            MemberModal("Nisha Shahi","F-204 Delta 1 Greater Noida","70","50 km"),
            MemberModal("Ankit Patnaik","F-204 Delta 1 Greater Noida","70","50 km"),
            MemberModal("Tejas Jha","F-204 Delta 1 Greater Noida","70","50 km"),
            MemberModal("Suyash Mishra","F-204 Delta 1 Greater Noida","70","50 km")
        )

        val adapter = memberAdapter(listMembers)

        val recycler = requireView().findViewById<RecyclerView>(R.id.RV_home)
        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.adapter = adapter
    }

    companion object {

        @JvmStatic
        fun newInstance() = HomeFragment()
    }
}