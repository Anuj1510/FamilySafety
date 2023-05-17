package com.example.familysafety

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


// version = 1 matlab hum jab bhi new data dalenge tub version increase ho jaayega
// exportSchema means agr hum new data dalenge tub humme apne purane data ko preserve krana hai ya nahi, false matlab no anad true matlab yes
// abstract class wo class hoti hai jisme hum functions bana to lete hai but usse define nahi krte hai
@Database(entities = [InviteModal::class], version = 1, exportSchema = false)
public abstract class FamilyDatabase:RoomDatabase() {

    abstract fun contactDao():ContactDao




    companion object{ //isme koi sa bhi function declare krdo wo pure application mai kahi pe bhi accessible hoga

        @Volatile // ye basically hamre app ko thread safe rakta hai. In Kotlin in order to force changes in a variable to be immediately visible to other threads, we can use the annotation @Volatile. If a variable is not shared between multiple threads, you don't need to use volatile keyword with that variable. I.e. when you apply volatile to a field of a class, it instructs the CPU to always read it from the RAM and not from the CPU cache. It also prevents instructions reordering; it acts as a memory barrier.
        private var INSTANCE:FamilyDatabase? = null

        fun getDatabase(context:Context):FamilyDatabase {

            INSTANCE?.let {
                return it
            }

            return synchronized(FamilyDatabase::class.java){
                val instance = Room.databaseBuilder(
                    context.applicationContext,FamilyDatabase::class.java,"Family_db"
                ).build()

                INSTANCE = instance

                instance
            }


        }

    }

}