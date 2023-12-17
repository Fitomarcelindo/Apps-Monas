package by.marcel.figma_kotlin.data

import android.annotation.SuppressLint
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.content.ContentValues
import android.util.Log

class DatabaseHelper(var context: Context) : SQLiteOpenHelper(context, "Marcel-Data4", null, 1) {
    private  val db = this.writableDatabase


    override fun onCreate(db: SQLiteDatabase?) {
        // Membuat tabel
//        if (db != null) {
            db?.execSQL(
                "CREATE TABLE User (" +
                        "UID INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "NAMA_MK varchar(50)," +
                        "KODE_MK varchar(50)," +
                        "RUANGAN varchar(50)," +
                        "STATUS varchar(50));"
            )
//            db.execSQL("INSERT INTO user (NAMA_MK,KODE_MK,RUANGAN,STATUS) VALUES ('PEMROM','B123','123','ONLINE'),('PEMROM','B123','123','ONLINE')")
//        }
        db?.execSQL("INSERT INTO user (NAMA_MK,KODE_MK,RUANGAN,STATUS) VALUES ('PEMROGRAMAN WEB','B123','123','ONLINE'),('BASIS DATA','B123','502','OFFLINE'),('Pem SQL','B31','502','OFFLINE'),('RPL ','D31','502','OFFLINE')")
//        db?.execSQL("INSERT INTO user VALUES ('','PEMROM','B123','123','ONLINE'),('','PEMROM','B123','123','ONLINE')")

    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // Perbarui tabel jika diperlukan
        db.execSQL("DROP TABLE IF EXISTS User")
        onCreate(db)
    }

    fun insertUser(user: User) {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put("NAMA_MK", user.namaMK)
        values.put("KODE_MK", user.kodeMK)
        values.put("RUANGAN", user.ruangan)
        values.put("STATUS", user.status)


        db.insert("User", null, values)
        db.close()
    }

    @SuppressLint("Range")
    fun getUser(): List<User> {
        val lsUser : MutableList<User> = ArrayList()
//        val db = this.readableDatabase
        val sql = "select * from user"
        val cursor = db.rawQuery(sql, null)
        if (cursor.moveToFirst()){
            do{
                val users = User (cursor.getString(0).toInt(),cursor.getString(1),cursor.getString(2), cursor.getString(3), cursor.getString(4))
                lsUser.add(users)
            }while (cursor.moveToNext())
        }
        cursor.close()
        return lsUser

    }

    fun getUserId(id: Int)  :MutableList<String> {
//        val db = this.readableDatabase
        val sql = "select * from user"
        val list1 : MutableList<String> = mutableListOf()
        val cursor = db.rawQuery(sql, null)
        if (cursor.moveToFirst()) {

            val id = cursor.getString(0).toString()
            val namaMK = cursor.getString(1)
            val kodeMK = cursor.getString(2)
            val ruangan = cursor.getString(3)
            val status = cursor.getString(4)
            cursor.close()
            list1.add(id)
            list1.add(namaMK)
            list1.add(kodeMK)
            list1.add(ruangan)
            list1.add(status)
            return list1
        }
        cursor.close()
        list1.add("")
        return list1

    }

    fun updateData(id: String?, user: User) {
//        val db = this.writableDatabase
        val values = ContentValues().apply {
            put("NAMA_MK", user.namaMK)
            put("KODE_MK", user.kodeMK)
            put("RUANGAN", user.ruangan)
            put("STATUS", user.status)
        }

        val updatedRows = db.update("User", values, "UID=?", arrayOf(user.uid.toString()))

        Log.d("DatabaseHelper", "Updated $updatedRows rows")
        db.close()
    }
}
