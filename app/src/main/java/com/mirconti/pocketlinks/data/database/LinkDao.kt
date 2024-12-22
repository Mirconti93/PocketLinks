package com.mircontapp.sportalbum.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface LinkDao {

    @Insert
    fun insert(vararg link: Link)

    @Insert
    fun insertAll(links: List<Link>)

    @Delete
    fun delete(link: Link)

    @Query("SELECT \n" +
            "    l.name,       -- ID del link\n" +
            "    l.url,           -- URL del link\n" +
            "    l.title,         -- Titolo del link\n" +
            "    l.description,   -- Descrizione del link\n" +
            "    C.categoria_id,  -- ID della categoria\n" +
            "    C.nome AS categoria_nome  -- Nome della categoria\n" +
            "FROM \n" +
            "    link l\n" +
            "JOIN \n" +
            "    association a ON L.link_id = a.link_id  -- Collega i link alle categorie tramite la tabella di relazione\n" +
            "JOIN \n" +
            "    category C ON a.categoria_id = C.categoria_id; ")
    fun getAll(): List<Link>

    @Update
    fun update(team: Link)

}