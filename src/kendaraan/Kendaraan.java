package kendaraan;

public abstract class Kendaraan {
    private String name, model, warna;
    private int tahun;

    public abstract void Start();

    public abstract void Stop();

    public abstract void Brake();
    
    public void getInfo(){
        System.out.println("Kendaraan: " + getName());
        System.out.println("Model : " + getModel());
        System.out.println("Warna : " + getWarna());
        System.out.println("Tahun : " + getTahun());
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getModel(){
        return model;
    }

    public void setModel(String model){
        this.model = model;
    }

    public String getWarna(){
        return warna;
    }

    public void setWarna(String warna){
        this.warna = warna;
    }

    public int getTahun(){
        return tahun;
    }

    public void setTahun(int tahun){
        this.tahun = tahun;
    }
}
