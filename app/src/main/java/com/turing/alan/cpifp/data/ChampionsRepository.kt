package com.turing.alan.cpifp.data

interface ChampionsRepository {

    fun getChampions(): List<Champion>
    fun getOne(id:Int):Champion

}