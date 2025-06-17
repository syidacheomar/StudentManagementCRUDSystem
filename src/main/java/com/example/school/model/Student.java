package com.example.school.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "murid")
public class Student {

    @Id
    private String id;
    private String nama;
    private String kelas;
    private int umur;

    // getters and setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public String getKelas() { return kelas; }
    public void setKelas(String kelas) { this.kelas = kelas; }

    public int getUmur() { return umur; }
    public void setUmur(int umur) { this.umur = umur; }
}
