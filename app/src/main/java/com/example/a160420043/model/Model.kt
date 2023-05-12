package com.example.a160420043.model

public data class Jadwal(
    val id:String?,
    val namaDokter:String?,
    val hari:String?,
    val photoUrl:String?
)

data class Obat(
    val id:String?,
    val name:String?,
    val kategori:String?,
    val photoUrl: String?
)

data class Layanan(
    val id:String?,
    val nama:String?,
    val keterangan:String?,
    val photoUrl: String?
)