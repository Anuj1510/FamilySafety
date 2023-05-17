package com.example.familysafety

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao  // Dao is basically data access object. Isme hum saare functions likhte hai insert ke delete ke
interface ContactDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE) // onConflict matlab agr mere paas same primary key aaya to mujhe kya krna hai kyuki primary key must be unique
    suspend fun insert(inviteModal: InviteModal)

    @Insert(onConflict = OnConflictStrategy.REPLACE) // onConflict matlab agr mere paas same primary key aaya to mujhe kya krna hai kyuki primary key must be unique
    suspend fun insertAll(inviteModalList: List<InviteModal>)

    @Query("SELECT * FROM inviteModal")
    suspend fun getAllContacts():List<InviteModal>


}