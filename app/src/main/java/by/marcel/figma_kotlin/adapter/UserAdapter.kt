package by.marcel.figma_kotlin.adapter

import android.annotation.SuppressLint
import android.app.Dialog
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import by.marcel.crud.data.entity.User
import by.marcel.figma_kotlin.R

@SuppressLint("ParcelCreator")
class UserAdapter(var list: List<User>): RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    private lateinit var dialog: Dialog



    interface Dialog {
        fun onClik(position: Int)
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var nama: TextView
        var kode: TextView
        var ruangan: TextView
        var status: TextView


        init {
            nama = view.findViewById(R.id.namaMK)
            kode = view.findViewById(R.id.kodeMK)
            ruangan = view.findViewById(R.id.ruangan)
            status = view.findViewById(R.id.status)
            view.setOnClickListener {
                dialog.onClik(layoutPosition)
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_home_page_dosen , parent, false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nama.text = list[position].namaMK
        holder.kode.text = list[position].kodeMK
        holder.ruangan.text = list[position].ruangan
        holder.status.text = list[position].status
    }

    override fun getItemCount(): Int {
        return list.size
    }


}
