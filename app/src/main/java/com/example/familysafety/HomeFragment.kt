package com.example.familysafety

import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
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


        val inviteadapter = inviteAdapter(fetchContacts())

        val inviterecycler = requireView().findViewById<RecyclerView>(R.id.recycler_invite)
        inviterecycler.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        inviterecycler.adapter = inviteadapter
    }

    private fun fetchContacts(): ArrayList<inviteModal> {

        val cr = requireActivity().contentResolver
        val cursor = cr.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null)

        val listContacts: ArrayList<inviteModal> = ArrayList()


        if (cursor != null && cursor.count > 0) {

            while (cursor != null && cursor.moveToNext()) {
                val id = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID))
                val name =
                    cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME))
                val hasPhoneNumber =
                    cursor.getInt(cursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER))

                if (hasPhoneNumber > 0) {

                    val pCur = cr.query(
                        ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                        null,
                        ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?",
                        arrayOf(id),
                        ""
                    )

                    if (pCur != null && pCur.count > 0) {

                        while (pCur != null && pCur.moveToNext()) {

                            val phoneNum =
                                pCur.getString(pCur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))

                            listContacts.add(inviteModal(name, phoneNum))

                        }
                        pCur.close()

                    }

                }
            }

            if (cursor != null) {
                cursor.close()
            }

        }
        return listContacts

    }

    companion object {

        @JvmStatic
        fun newInstance() = HomeFragment()
    }
}