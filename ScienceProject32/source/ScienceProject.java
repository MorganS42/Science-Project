import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class ScienceProject extends PApplet {

int money=20000;
float hap=0; //happiness
int bud=-2500; //budget

int day=1;

float speed = 300;

int time=round(speed/3);
int t=round(speed/3);

int tc=0; //truck count
int ec=0;

int sc1=0;
int sc2=0;
int sc3=0;

//int hd=1; //house demand
float demand=0;
float supply=0;

boolean bc=false; //button clicked
int bn; //button number

PImage dirt;
PImage grass;
PImage clock;
PImage wall;

PImage worker;
PImage truck;

PImage s1;
PImage s2;

PImage warn;
PImage media;

PImage[][] trash = new PImage[4][1];

String[] days = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};

String[] facts = {
"Recycling is a process to create new items from old and used materials. This helps in reducing energy and potentially useful materials from being wasted.",
"Recycling is a part of waste disposal hierarchy \u2013 Reduce, Reuse, Recycle.",
"Aluminium cans can actually be recycled and put back onto the shelf at your local grocery store in just about 2 months.",
"Aluminium cans are probably the most recycled item, at least in the United States. While this is true, you can also recycle other forms of aluminium as well.",
"Recycling an aluminium can help to save a great deal of energy, in fact, enough to run your home television for about three hours!",
"Most beverage cans are made up of aluminium, even though there are other products that go into it as well.",
"If you throw away your aluminium cans, they can stay in that can form for up to 500 years or more- so recycling is the way to go.",
"Variety of raw materials including paper, plastic, metal, glass, electronics and textiles can be recycled.",
"You can recycle aluminium over and over again, and there is really no limit to it.",
"There are over 80 billion aluminium cans used each and every year around the world.",
"Aluminium used to be more valuable than gold, many years ago.",
"Half a million trees have to be cut down just to produce the Sunday newspapers each week.",
"Recycling a single days worth of the New York Times could save 75,000 trees or more.",
"Recycling helps to conserve our natural resources like coal, oil and gas.",
"If we recycled all newspapers, we could save over 250 million trees each and every year.",
"Most people in America all use at least seven trees each year, through wood, paper and other types of products that use trees. That is over 2 trillion trees throughout the course of the year when you think about it.",
"Each American uses around 680 pounds of paper each year, and most people just throw it away instead of recycling it for further use.",
"2000 pounds of recycled paper can actually help to save 17 trees, over 350 gallons of oil, and a lot of landfill space. That also means less air pollution!",
"Recycling helps to conserve energy and as a result less greenhouse gases are emitted.",
"Americans will use over 2 and a half million plastic bottles every thirty minutes, and most of them are simply thrown away rather than recycled.",
"Plastic bags that are thrown into the ocean kill over a million sea creatures a year.",
"Over 60% of the trash that ends in dustbin could be recycled.",
"Over 25 trillion Styrofoam coffee cups are thrown away each year, just by Americans!",
"Glass jars can be recycled, but there are many that are just thrown away.",
"24 trees are cut down to make 1 ton of newspaper.",
"Recycling helps to reduce the amount of waste that goes to landfills and as a result less harmful emissions like methane gas are released into the earth\u2019s atmosphere.",
"A modern glass bottle could take over 4000 years to actually decompose, and if it is in the landfill then it will probably take even longer than that.",
"Most dumps are made up of a third of packaging materials that could be recycled.",
"Recycled paper produces approximately 70% less air pollution than if it was made from raw materials.",
"Each year, there are organic garbage thrown out that could be composted and recycled to use for fertilizer for the ground rather than pollutants.",
"Glass is 100% recyclable and can be used again and again. Glass recycling is separated into colors because glass retains its color even after recycling.",
"The most thrown away products in American include diapers, pens, razor blades, tires and aluminium- all of which can be used to be recycled into other products.",
"Due to the fact that people aren\u2019t recycling as much as they should, the rainforests are actually be cut down by about 100 acres a minute.",
"Most people produce 4.4 pounds of trash per day that results in about 1.5 tons of solid waste per year.",
"Plastic bags and garbage that are thrown into the ocean have devastating effect on sea animals.",
"Approximately 1 billion trees worth of paper are thrown in US every year.",
"The amount of wood and paper that are thrown each year is enough to heat 50,000,000 homes for 20 years.",
"Recycling one ton of plastic can save up to 1,000\u20132,000 gallons of gasoline.",
"Recycling one glass bottle saves enough energy to power a 100-watt bulb for four hours.",
"One drip one second from a leaky faucet wastes 540 gallons of water a year.",
"In less than 15 years, worldwide waste is expected to double.",
"Australia is one of the countries that generate the highest waste amounts.",
"Waste materials that are not recycled end up in already densely packed landfills.",
"It would take a million years before a glass bottle decomposes.",
"Aluminium recycling saves a lot of energy.",
"Recycling paper is always the better option than throwing it away.",
"In 2008, Australia became the top newspaper recycler in the world.",
"Plastic bags are one of the major waste materials produced in Australia.",
"Around 376,000 tonnes of plastic packaging are used by Australians every year.",
"Every year, about a million sea creatures die because of the plastics disposed into the ocean.",
"Australia produces a significant amount of electronic waste."
};

button[] buttons = new button[4];
window[] windows = new window[buttons.length];

boolean mousec=false; //mouse clicked
int mhs=0; //mouse held state
pile[] Pile = new pile[5];

ArrayList<news> News = new ArrayList<news>();
ArrayList<news> tnews = new ArrayList<news>();

Boolean[] warns = new Boolean[6];

Boolean p=false;
int pt=0;

public void setup() {
   
  dirt=loadImage("C:/Users/StoodleyM23/OneDrive - Barker College/Desktop/All-Random--master/ScienceProject/Images/dirt.jpg", "jpg");
  grass=loadImage("C:/Users/StoodleyM23/OneDrive - Barker College/Desktop/All-Random--master/ScienceProject/Images/grass.jpg", "jpg");
  
  clock=loadImage("C:/Users/StoodleyM23/OneDrive - Barker College/Desktop/All-Random--master/ScienceProject/Images/clock.png", "png");
  
  wall=loadImage("C:/Users/StoodleyM23/OneDrive - Barker College/Desktop/All-Random--master/ScienceProject/Images/wall.png", "png");
  
  worker=loadImage("C:/Users/StoodleyM23/OneDrive - Barker College/Desktop/All-Random--master/ScienceProject/Images/worker.png", "png");
  truck=loadImage("C:/Users/StoodleyM23/OneDrive - Barker College/Desktop/All-Random--master/ScienceProject/Images/truck.png", "png");
  
  s1=loadImage("C:/Users/StoodleyM23/OneDrive - Barker College/Desktop/All-Random--master/ScienceProject/Images/sorter.png", "png");
  s2=loadImage("C:/Users/StoodleyM23/OneDrive - Barker College/Desktop/All-Random--master/ScienceProject/Images/sorter2.png", "png");
  
  warn=loadImage("C:/Users/StoodleyM23/OneDrive - Barker College/Desktop/All-Random--master/ScienceProject/Images/warning.png", "png");
  media=loadImage("C:/Users/StoodleyM23/OneDrive - Barker College/Desktop/All-Random--master/ScienceProject/Images/media.png", "png");
  
  trash[0][0]=loadImage("C:/Users/StoodleyM23/OneDrive - Barker College/Desktop/All-Random--master/ScienceProject/Images/p1.png", "png");
  trash[1][0]=loadImage("C:/Users/StoodleyM23/OneDrive - Barker College/Desktop/All-Random--master/ScienceProject/Images/g1.png", "png");
  trash[2][0]=loadImage("C:/Users/StoodleyM23/OneDrive - Barker College/Desktop/All-Random--master/ScienceProject/Images/c1.png", "png");
  trash[3][0]=loadImage("C:/Users/StoodleyM23/OneDrive - Barker College/Desktop/All-Random--master/ScienceProject/Images/m1.png", "png");
  
  buttons[0]=new button(width/9*8,50,300,75,"Collection");
  buttons[1]=new button(width/9*8,150,300,75,"Sorting");
  buttons[2]=new button(width/9*8,250,300,75,"Management");
  buttons[3]=new button(width/9*8,350,300,75,"Budget");
  
  windows[0]=new window(width/2-900,height/2-500,1800,1000,0);
  windows[1]=new window(width/2-900,height/2-500,1800,1000,1);
  windows[2]=new window(width/2-900,height/2-500,1800,1000,2);
  windows[3]=new window(width/2-900,height/2-500,1800,1000,3);
  
  Pile[0]=new pile(width/12,height/10*7,0,false, 311);
  Pile[1]=new pile(width/12*4,height/10*7,0,true, 111);
  Pile[2]=new pile(width/12*6,height/10*7,1,true, 111);
  Pile[3]=new pile(width/12*8,height/10*7,2,true, 111);
  Pile[4]=new pile(width/12*10,height/10*7,3,true, 111);
  
  
  reload();
  
  for(int i=0; i<warns.length; i++) {
    warns[i]=false;  
  }
  //warns[5]=true;
}

public void na(Boolean w, String s) { //news add
  for(news n : News) {
    n.move(true);  
  }
  News.add(new news(w,width/2-300,0,600,200,800,s));
  tnews.add(new news(w,width/2-300,0,600,200,800,s));
}

public void fact() {
  String s = "Did you know? \n"+facts[round(random(0,facts.length-1))];  
  fill(128);
  stroke(0);
  strokeWeight(8);
  rect(width/2-500,height/2-200,1000,400);
  textSize(40);
  fill(0);
  text(s,width/2-500+8,height/2-200+8,1000-28,400-8);
  strokeWeight(1);
}

public void draw() { 
  if(!p) {
    if(!bc) {
      for(pile p : Pile) {
        p.up(); 
      }
      for(int i=0; i<Pile.length; i++) {
        if(Pile[i].trc>=round(Pile[i].max/2.0f)*round(Pile[i].max/2.0f)) {
          if(!warns[i]) {
            warns[i]=true;
            if(i==0) {
              na(true,"Pile number "+(i+1)+" is full! This means you will not be able to recieve any more garbage, this causes your happiness to drop! To fix this you need to sort your rubbish and/or manage your rubish, find out more in Sorting and/or Management.");  
            }
            else {
              na(true,"Pile number "+(i+1)+" is full! To fix this you need to manage your rubish, find out more in Management.");  
            }
          }
        }
        else {
          warns[i]=false;
        }
      }
      
      if(demand>supply) {
        if(!warns[5]) {
          warns[5]=true;
          na(true,"Your demand is higher then your supply, this means you can not collect everyones rubbish. This results in decreased happiness, which results in a lower budget. Find out more in Collection.");    
        }
      }
      else {
        warns[5]=false;  
      }
      
      for(int i=0; i<(sc1*200+sc2*1000+sc3*10000)/speed; i++) {
        Pile[0].so();  
      }
      
      if(day>1) {
        if(hap>50) {
          demand+=(hap-49)/20;
        }
        else {
          demand+=0.2f;  
        }
      }
      if(ec>tc) {
        supply=tc*1000;
      }
      else {
        supply=ec*1000;  
      }
      if(Pile[0].trc>=round(Pile[0].max/2.0f)*round(Pile[0].max/2.0f)) {
        supply=0;  
      }
      time++;
      if(time>speed/2) {
        t--;
      }
      else {
        t++;  
      }
      if(time==speed) {
        time=0;
        t=0;
      }
      if(time==0) {
        day++;
        reload();
        if(supply>demand) {
          hap=100;
        }
        else {
          hap=supply/demand*100.0f;
        }
        if(supply>demand) {
          bud=round(hap*demand/10-2500.0f);
        }
        else {
          bud=round(hap*supply/10-2500.0f);  
        }
        if(ec>tc) {
          bud-=tc*1000;
        }
        else {
          bud-=ec*1000;
        }
        
        bud-=sc1*800+sc2*100+sc3*100;
        
        if(day%7==0) {
          money+=bud;
          
          fact();  
          p=true;
          pt=400;
        }  
      }
      
      if(time==speed/2) {
        if(supply>demand) {
          Pile[0].to+=demand; 
        }
        else {
          Pile[0].to+=supply;
        }
      }
      
      //println(time);
      fill((t/(speed))*130.0f,(t/(speed))*200.0f,(t/(speed))*255.0f);
      stroke((t/(speed))*130.0f,(t/(speed))*200.0f,(t/(speed))*255.0f);
      rect(0,0,width,height/4);
      
      stroke(0);
      fill(255);
      textSize(42);
      text("Day: "+day+", "+days[(day-1)%days.length],50,75);
      text("Happiness: "+round(hap)+"%",500,75);
      text("Budget (Weekly): $"+bud,500,175);
      text("Money: $"+money,1080,75);
      text("Rubish Supply: "+round(supply),1500,75);
      text("Rubish Demand: "+round(demand),1500,175);
      image(clock,20,100,200,200);
      
      
      translate(120, 200); 
      rotate(map(time%(speed/2.0f),0.0f,speed/2.0f,-PI,PI));//random(-PI,PI));
      rect(-5,-5,10,60);
      
      rotate(-map(time%(speed/2.0f),0.0f,speed/2.0f,-PI,PI));
      translate(-120,-200);
    
      for(int i=0; i<buttons.length; i++) {
        buttons[i].show();  
        if(buttons[i].clicked()) {
          bn=i;  
          bc=true;
        }
      } 
      if(bc) {
        filter(BLUR,10);  
      }
      
      for(news n : News) {
        n.show();  
      }
      News.clear();
      for(int i=0; i<tnews.size(); i++) {
        News.add(tnews.get(i));
      }
    }
    else {
      windows[bn].run();  
    }
    
    if(mousePressed) {
      if(mhs!=0) {
        mousec=false; 
        if(mhs>150) {
          mousec=true;  
        }
        else if(mhs>15 && mhs%(200-mhs)==0) {
          mousec=true;
        }
      }
      else {
        mousec=true;
      }
      mhs++;
    }
    else {
      mousec=false;
      mhs=0;
    }
  }
  else {
    pt--;
    if(pt==0) {
      p=false;
      reload();
    }
  }
}

class junk {
  int type; //0=plastic 1=glass 2=paper 3=metal
  int t2; //type 2
  float r=random(-PI,PI); //rotate
  boolean sorted;
  int x;
  int y;
  int s; //size
   
  junk(int ty, int xx, int yy, boolean so) {
    type=ty;
    t2=0;
    sorted=so;
    x=xx;
    y=yy;
    s=20;
  }
  
  public void show() {
    translate(x, y); 
    rotate(r);
    image(trash[type][t2],0,0,s,s);   
    rotate(-r);
    translate(-x,-y);
  }
}

public void reload() {
  for(int x=0; x<width; x+=150) {
    for(int y=height/4; y<height/10*7; y+=150) {
      image(wall, x, y,150,150);
    }
  }
  
  for(int x=0; x<width; x+=350) {
    for(int y=height/10*7; y<height; y+=350) {
      image(dirt, x, y,350,350);
    }
  }
  
  for(int x=0; x<width; x+=35) {
    image(grass, x, height/10*7,35,35);
  }
  for(pile p : Pile) {
    for(junk j : p.Junk) {
      j.show(); 
    }
  }
}

class pile {
  int type;
  int to=0; //trash owed
  boolean sorted;
  int size=1;
  int s2=1; //size 2
  int trc=0; //trash count
  int ts=5; //trash size
  int max;
  ArrayList<PVector> pos = new ArrayList<PVector>();
  ArrayList<Boolean> boo = new ArrayList<Boolean>();
  
  ArrayList<junk> Junk = new ArrayList<junk>();
  
  int x;
  int y;
  
  pile(int xx, int yy, int ty, boolean so, int m) {
    x=xx;
    y=yy;
    pos.add(new PVector(xx,yy));
    boo.add(false);
    
    max=m;
    
    type=ty;
    sorted=so;
  }
  
  public void so() {
    if(Junk.size()>0) {
      Pile[Junk.get(Junk.size()-1).type+1].to++;
      
      if(to>0) {
        to--;  
      }
      else {
        trc--;
        boo.set(Junk.size()-1,false);
        Junk.remove(Junk.size()-1);
        if(trc==s2-size) {
          this.ds();  
        }
      }
    }
  }
  
  public void up() { //update
    for(int i=0; i<to/10; i++) {
      to--;
      this.at();
    }
  }
  
  public void at() { //add trash
    trc++;
    to--;
    int i=0;
    while(boo.get(i)==true) {
      i++;
    }
    boo.set(i,true);
    if(!sorted) {
      Junk.add(new junk(round(random(0,trash.length-1)),round(pos.get(i).x),round(pos.get(i).y),sorted));
    }
    else {
      Junk.add(new junk(type,round(pos.get(i).x),round(pos.get(i).y),sorted)); 
    }
    Junk.get(Junk.size()-1).show();
    if(trc==s2) {
      this.us();  
    }
  }
  
  public void us() { //up size
    size+=2;
    s2+=size;
    
    for(int i=0; i<size; i++) {
      pos.add(new PVector(x+(i-floor(size/2.0f))*ts,y+(abs(i-floor(size/2.0f))-floor(size/2.0f))*ts));  
      boo.add(false);
    }
  }
  
  public void ds() {
    size-=2;
    s2-=size;
    
    for(int i=0; i<size; i++) {
      pos.remove(pos.size()-1);  
      boo.remove(pos.size()-1);
    }  
  }
}

class button {
  int x;
  int y;
  int w;
  int h;
  String name;
  
  button(int xx, int yy, int ww, int hh, String n) {
    x=xx;
    y=yy;
    w=ww;
    h=hh;
    
    name=n;
  }
  
  public Boolean clicked() {
    if(mouseX>x && mouseX<x+w && mouseY>y && mouseY<y+h && mousec) {
      return true;  
    }
    else {
      return false;
    }
  }
  
  public void show() {
    fill(128);
    stroke(0);
    if(mouseX>x && mouseX<x+w && mouseY>y && mouseY<y+h) {
      fill(65);
    }
    strokeWeight(4);
    rect(x,y,w,h);
    strokeWeight(1);
    fill(0);
    text(name,x+w/12,y+h/3*2);
  }
}

class window {
  int x;
  int y;
  int w;
  int h;
  int type;
  
  window(int xx, int yy, int ww, int hh, int n) {
    x=xx;
    y=yy;
    w=ww;
    h=hh;
    
    type=n;
  }
  
  public void run() {
    //x=mouseX;
    //y=mouseY;
    
    fill(128);
    stroke(0);
    strokeWeight(6);
    rect(x,y,w,h);
    //strokeWeight(1); 
    
    fill(200);
    rect(x,y,w,h/12);
    
    
    if(mouseX>x+w/20*19 && mouseX<x+w && mouseY>y && mouseY<y+h/12) {
      fill(255,0,0);  
    }
    rect(x+w/20*19,y,w/20,h/12);

    strokeWeight(12);
    stroke(255,0,0);
    if(mouseX>x+w/20*19 && mouseX<x+w && mouseY>y && mouseY<y+h/12) {
      stroke(255);  
    }
    line(x+w/20*19+12,y+12,x+w-12,y+h/12-12);
    line(x+w/20*19+12,y+h/12-12,x+w-12,y+12);


    int xo;
    int yo;
    switch(type) {
      case 0:
        fill(0);
        textSize(60);
        text("Garbage Truck",x+w/40,y+h/6);
        text(tc,x+w/2.2f,y+h/6);
        image(truck,x+w/3.7f,y+h/10,h/10,h/12);
        strokeWeight(6);
        stroke(0);
        
        xo=80;
        yo=0;
        fill(200);
        if(mouseX>x+w/3.5f+xo && mouseX<x+w/3.5f+xo+h/12 && mouseY>yo+y+h/10 && mouseY<yo+y+h/10+h/12) { 
          textbox(x+w/3.5f+xo+h/24,yo+y+h/10+h/24,400,200,600,300,"Selling a truck will give you half of the original price back, $5,000. "+(tc == 0 ? "You don't have any trucks so you can't sell any!" : ""));
          fill(150);  
          if(mousec && tc>0) {
            money+=5000;
            tc--;
          }
        }
        strokeWeight(6);
        stroke(0);
        if(tc<1) {
          fill(100);  
        }
        rect(x+w/3.5f+xo,y+h/10+yo,h/12,h/12);
        line(x+w/3.5f+10+xo,y+h/10+h/24+yo,x+w/3.5f+h/12-10+xo,y+h/10+h/24+yo);
        
        fill(200);
        if(mouseX>x+w/3.5f+xo+h/12 && mouseX<x+w/3.5f+xo+h/12+h/12 && mouseY>y+h/10+yo && mouseY<y+h/10+h/12+yo) {
          textbox(x+w/3.5f+xo+h/24*3,y+h/10+h/24,400-h/12+yo,200,600,300,"A truck costs $10,000. You need one employe to run one truck, a truck picks up 1000 pieces of garbage a day."+(money < 10000 ? "You don't have enough money!" : ""));
          fill(150);
          if(mousec && money>=10000) {
            money-=10000;
            tc++;
          }
        }
        strokeWeight(6);
        stroke(0);
        if(money<10000) {
          fill(100);  
        }
        rect(x+w/3.5f+h/12+xo,y+h/10+yo,h/12,h/12);
        line(x+w/3.5f+10+h/12+xo,yo+y+h/10+h/24,x+w/3.5f+h/12-10+h/12+xo,yo+y+h/10+h/24);
        line(x+w/3.5f+h/24+h/12+xo,yo+y+h/10+10,x+w/3.5f+h/12+h/24+xo,yo+y+h/10+h/12-10);
        
        
        
        
        fill(0);
        textSize(60);
        text("Employee",x+w/40,y+h/6+100);
        text(ec,x+w/2.2f,y+h/6+100);
        image(worker,x+w/3.7f,y+h/10+100,h/8,h/12);
        strokeWeight(6);
        stroke(0);
        
        xo=80;
        yo=100;
        fill(200);
        if(mouseX>x+w/3.5f+xo && mouseX<x+w/3.5f+xo+h/12 && mouseY>yo+y+h/10 && mouseY<yo+y+h/10+h/12) { 
          textbox(x+w/3.5f+xo+h/24,yo+y+h/10+h/24,400,200,600,300,"Selling an employee will save you $1,000 a week."+(ec == 0 ? "You don't have any employees so you can't sell any!" : ""));
          fill(150);  
          if(mousec && ec>0) {
            ec--;
          }
        }
        strokeWeight(6);
        stroke(0);
        if(ec<1) {
          fill(100);  
        }
        rect(x+w/3.5f+xo,y+h/10+yo,h/12,h/12);
        line(x+w/3.5f+10+xo,y+h/10+h/24+yo,x+w/3.5f+h/12-10+xo,y+h/10+h/24+yo);
        
        fill(200);
        if(mouseX>x+w/3.5f+xo+h/12 && mouseX<x+w/3.5f+xo+h/12+h/12 && mouseY>y+h/10+yo && mouseY<y+h/10+h/12+yo) {
          textbox(x+w/3.5f+xo+h/24*3,y+h/10+h/24+yo,400-h/12,200,700,300,"An employee costs $200 and a salary $1,000 a week. Each employee runs one truck. Employees without a truck available will not be payed. "+(money < 100 ? "You don't have enough money!" : ""));
          fill(150);
          if(mousec && money>=200) {
            ec++;
            money-=200;
          }
        }
        strokeWeight(6);
        stroke(0);
        if(money<200) {
          fill(100);  
        }
        rect(x+w/3.5f+h/12+xo,y+h/10+yo,h/12,h/12);
        line(x+w/3.5f+10+h/12+xo,yo+y+h/10+h/24,x+w/3.5f+h/12-10+h/12+xo,yo+y+h/10+h/24);
        line(x+w/3.5f+h/24+h/12+xo,yo+y+h/10+10,x+w/3.5f+h/12+h/24+xo,yo+y+h/10+h/12-10);
      break;
      
      case 1:
        fill(0);
        textSize(60);
        text("Human sorter",x+w/40,y+h/6);
        text(sc1,x+w/2.2f,y+h/6);
        image(worker,x+w/3.7f,y+h/10,h/8,h/12);
        strokeWeight(6);
        stroke(0);
        
        xo=80;
        yo=0;
        fill(200);
        if(mouseX>x+w/3.5f+xo && mouseX<x+w/3.5f+xo+h/12 && mouseY>yo+y+h/10 && mouseY<yo+y+h/10+h/12) { 
          textbox(x+w/3.5f+xo+h/24,yo+y+h/10+h/24,400,200,600,300,"Selling a worker stops you from paying $800 a week."+(sc1 == 0 ? "You don't have any workers so you can't sell any!" : ""));
          fill(150);  
          if(mousec && sc1>0) {
            sc1--;
          }
        }
        strokeWeight(6);
        stroke(0);
        if(sc1<1) {
          fill(100);  
        }
        rect(x+w/3.5f+xo,y+h/10+yo,h/12,h/12);
        line(x+w/3.5f+10+xo,y+h/10+h/24+yo,x+w/3.5f+h/12-10+xo,y+h/10+h/24+yo);
        
        fill(200);
        if(mouseX>x+w/3.5f+xo+h/12 && mouseX<x+w/3.5f+xo+h/12+h/12 && mouseY>y+h/10+yo && mouseY<y+h/10+h/12+yo) {
          textbox(x+w/3.5f+xo+h/24*3,y+h/10+h/24,400-h/12+yo,200,600,300,"A worker costs $150 and has a salary of $800 per week. A human worker sorts 200 items in a day."+(money < 150 ? "You don't have enough money!" : ""));
          fill(150);
          if(mousec && money>=150) {
            money-=150;
            sc1++;
          }
        }
        strokeWeight(6);
        stroke(0);
        if(money<150) {
          fill(100);  
        }
        rect(x+w/3.5f+h/12+xo,y+h/10+yo,h/12,h/12);
        line(x+w/3.5f+10+h/12+xo,yo+y+h/10+h/24,x+w/3.5f+h/12-10+h/12+xo,yo+y+h/10+h/24);
        line(x+w/3.5f+h/24+h/12+xo,yo+y+h/10+10,x+w/3.5f+h/12+h/24+xo,yo+y+h/10+h/12-10);
        
        
        
        
        fill(0);
        textSize(60);
        text("Basic Sorter",x+w/40,y+h/6+100);
        text(sc2,x+w/2.2f,y+h/6+100);
        image(s1,x+w/3.5f,y+h/10+100,h/13,h/13);
        strokeWeight(6);
        stroke(0);
        
        xo=80;
        yo=100;
        fill(200);
        if(mouseX>x+w/3.5f+xo && mouseX<x+w/3.5f+xo+h/12 && mouseY>yo+y+h/10 && mouseY<yo+y+h/10+h/12) { 
          textbox(x+w/3.5f+xo+h/24,yo+y+h/10+h/24,400,200,600,300,"Selling a Basic Sorter will give you half the original price, $4,000 and will stop you from paying the weekly fee of $500."+(sc2 == 0 ? "You don't have any Basic Sorters so you can't sell any!" : ""));
          fill(150);  
          if(mousec && sc2>0) {
            sc2--;
          }
        }
        strokeWeight(6);
        stroke(0);
        if(sc2<1) {
          fill(100);  
        }
        rect(x+w/3.5f+xo,y+h/10+yo,h/12,h/12);
        line(x+w/3.5f+10+xo,y+h/10+h/24+yo,x+w/3.5f+h/12-10+xo,y+h/10+h/24+yo);
        
        fill(200);
        if(mouseX>x+w/3.5f+xo+h/12 && mouseX<x+w/3.5f+xo+h/12+h/12 && mouseY>y+h/10+yo && mouseY<y+h/10+h/12+yo) {
          textbox(x+w/3.5f+xo+h/24*3,y+h/10+h/24+yo,400-h/12,200,700,300,"A Basic Sorter costs $8,000 and $100 a week to maintain. A basic sorter sorts 1000 items a day."+(money < 8000 ? "You don't have enough money!" : ""));
          fill(150);
          if(mousec && money>=8000) {
            sc2++;
            money-=8000;
          }
        }
        strokeWeight(6);
        stroke(0);
        if(money<8000) {
          fill(100);  
        }
        rect(x+w/3.5f+h/12+xo,y+h/10+yo,h/12,h/12);
        line(x+w/3.5f+10+h/12+xo,yo+y+h/10+h/24,x+w/3.5f+h/12-10+h/12+xo,yo+y+h/10+h/24);
        line(x+w/3.5f+h/24+h/12+xo,yo+y+h/10+10,x+w/3.5f+h/12+h/24+xo,yo+y+h/10+h/12-10);
        
        
        
        
        fill(0);
        textSize(60);
        text("Advanced Sorter",x+w/40,y+h/6+200);
        text(sc3,x+w/2.2f,y+h/6+200);
        image(s2,x+w/3.5f,y+h/10+200,h/13,h/13);
        strokeWeight(6);
        stroke(0);
        
        xo=80;
        yo=200;
        fill(200);
        if(mouseX>x+w/3.5f+xo && mouseX<x+w/3.5f+xo+h/12 && mouseY>yo+y+h/10 && mouseY<yo+y+h/10+h/12) { 
          textbox(x+w/3.5f+xo+h/24,yo+y+h/10+h/24,400,200,600,300,"Selling a Advanced Sorter will give you half the original price, $10,000 and will stop you from paying the weekly fee of $200."+(ec == 0 ? "You don't have any Advanced Sorters so you can't sell any!" : ""));
          fill(150);  
          if(mousec && sc3>0) {
            sc3--;
          }
        }
        strokeWeight(6);
        stroke(0);
        if(sc3<1) {
          fill(100);  
        }
        rect(x+w/3.5f+xo,y+h/10+yo,h/12,h/12);
        line(x+w/3.5f+10+xo,y+h/10+h/24+yo,x+w/3.5f+h/12-10+xo,y+h/10+h/24+yo);
        
        fill(200);
        if(mouseX>x+w/3.5f+xo+h/12 && mouseX<x+w/3.5f+xo+h/12+h/12 && mouseY>y+h/10+yo && mouseY<y+h/10+h/12+yo) {
          textbox(x+w/3.5f+xo+h/24*3,y+h/10+h/24+yo,400-h/12,200,700,300,"A Advanced Sorter costs $20,000 and $100 a week to maintain. A Advanced Sorter sorts 10000 items a day."+(money < 20000 ? "You don't have enough money!" : ""));
          fill(150);
          if(mousec && money>=20000) {
            sc3++;
            money-=20000;
          }
        }
        strokeWeight(6);
        stroke(0);
        if(money<20000) {
          fill(100);  
        }
        rect(x+w/3.5f+h/12+xo,y+h/10+yo,h/12,h/12);
        line(x+w/3.5f+10+h/12+xo,yo+y+h/10+h/24,x+w/3.5f+h/12-10+h/12+xo,yo+y+h/10+h/24);
        line(x+w/3.5f+h/24+h/12+xo,yo+y+h/10+10,x+w/3.5f+h/12+h/24+xo,yo+y+h/10+h/12-10);
      break;
    }
    
    
    if(mouseX>x+w/20*19 && mouseX<x+w && mouseY>y && mouseY<y+h/12 && mousec) {
      bc=false;
      reload();
    }
  }
}

public void textbox(float x,float y,float xt, float yt, float w,float h, String t) {
  strokeWeight(8);
  stroke(80);
  line(x,y,x+xt,y+yt+h/2);
  fill(0);
  rect(x+xt,y+yt,w,h);
  fill(0,255,0);
  textSize(35);
  text(t,x+xt+16,y+yt+16,w-30,h-16);
  strokeWeight(1);
  
  fill(200);
}

class news {
  boolean warning;
  int x;
  int y;
  int w;
  int h;
  String m; //message
  int t; //time alive
  news(boolean wa, int xx, int yy, int ww, int hh, int tt,String me) {
    warning=wa;
    x=xx;
    y=yy;
    w=ww;
    h=hh;
    t=tt;
    m=me;
  }
  public void show() {
    stroke(0,t);
    strokeWeight(6);
    fill(128,t);
    tint(255,t);
    rect(x,y,w,h);
    textSize(18);
    fill(0,t);
    text(m,x+h,y+8,w-h-18,h-8);
    if(warning) {
      image(warn,x+h/5,y+h/5,h/3*2,h/3*2);  
    }
    else {
      image(media,x,y,h*1.25f,h);  
    }
    tint(255,255);
    t--;
    
    if(t==0 || (mousec && mouseX>x && mouseX<x+w && mouseY>y && mouseY<y+h)) {
      for(int i=tnews.indexOf(this); i>=0; i--) {
        tnews.get(i).move(false);
      }
      tnews.remove(tnews.indexOf(this)); 
    }
    strokeWeight(1);
  }
  public void move(Boolean down) {
    if(down) {
      y+=h;  
    }
    else {
      y-=h;  
    }
  }
}
  public void settings() {  fullScreen(); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--present", "--window-color=#666666", "--hide-stop", "ScienceProject" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
