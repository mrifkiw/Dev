package com.company;

public class Player {
    public String name;
    public String type;
    protected double healthPoint;
    private int attackPoint;
    private int item;
    protected int level;

    public void attackWithItem(Player Lawan){
        System.out.println("["+this.name + "'s Item activated]");
        if(this.item <=0){
            System.out.println("No Item in Your Backpack");
        }else if(this.item > 0 && this.level ==0 ){
            Lawan.healthPoint = Lawan.healthPoint - this.attackPoint;
            this.item=this.item - 1;
        }else if(this.item>0 && this.level>0 ){
            Lawan.healthPoint = Lawan.healthPoint - this.level*1.5*this.attackPoint;
            this.item=this.item - 1;
        }

        if (Lawan.isDeath()){
            levelUp();
        }

    }

    private void levelUp(){
        this.level = this.level + 1;
    }

    public Player(String name, String type, int attackPoint) {
        this.name = name;
        this.type = type;
        this.attackPoint= attackPoint;
        this.item=0;
        this.level=0;

        if (this.type=="player"){
            this.healthPoint=1800;
        }else if(this.type=="monster"){
            this.healthPoint=1000;
        }else{
            this.healthPoint=0;
        }
    }

    public void collectItem(){
        this.item =+1;
    }

    public String getName() {
        return this.name;
    }

    public double getHealthPoint() {
        return this.healthPoint;
    }

    public void setHealthPoint(int point) {
        this.healthPoint = point;
    }

    public void addHealthPoint(int point){
        this.healthPoint=+point;
    }

    public void attack(Player Lawan){
        Lawan.healthPoint= Lawan.healthPoint - this.attackPoint;
        if (Lawan.isDeath()){
            levelUp();
        }
    }

    public boolean isDeath(){
        if(this.healthPoint<=0){
            return true;
        }else{
            return false;
        }
    }

    public void tampilStat(){
        System.out.print("Player [" + Player.this.getName() +"] =>> ");
        System.out.print(" | Type : " + Player.this.type);
        System.out.print(" | HealthPoint : " + Player.this.getHealthPoint());
        System.out.print(" | Item : " + Player.this.item);
        System.out.println(" | Level : " + Player.this.level);
    }

    public void cekLife(){
        if(this.name=="Dark"){
            if(Player.this.isDeath()){
                System.out.println("Dark was Death");
            }else{
                System.out.println("Dark is still alive");
            }
        }else if(this.name=="Slime"){
            if(Player.this.isDeath()){
                System.out.println("Slime was Death");
            }else{
                System.out.println("Slime is still alive");
            }
        }
    }

    public void healingSpell(){
        System.out.println("</> " +Player.this.getName()+ " used the healingSpell.");
        if(Player.this.getName()=="Dark"){
            Player.this.healthPoint = 1800;
        }else {
            Player.this.healthPoint= 1000;
        }
    }




}
