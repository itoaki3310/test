var star=1;
while(star<=5){
        document.write("★<br>");
    star++;
}
document.write("<br>");

var star=1;
while(star<=6){
        if(star==4){
        document.write("<br>");}
        document.write("★");
    star++;}
document.write("<br><br>");

var star=1;
while(star<=10){
        if(star==6){
        document.write("<br>");
    }
        document.write("☆");
    star++;
}
document.write("<br><br>");


var star=0;
while(star<20){
        if(star%5==0){
        document.write("<br>"); }
        document.write("★");
    star++;
}
document.write("<br><br>");

var star=0;
while(star<12){
        if(star%3==0){
        document.write("<br>"); }
        document.write("★");
    star++;
}
document.write("<br><br>");

var star1=1;
while(star1<=6){
    if(star1%2==0){
        document.write("☆");       
    }else if(star1%2==1){
        document.write("<br>");   
    }
        document.write("★");
        star1++;}
document.write("<br><br>");

var star1=1;
while(star1<=12){
    if(star1%3==1){
        document.write("<br>");      
   }else if(star1%2==0){
        document.write("☆");     
   }else if(star1%2==1){
        document.write("☆");    
   }
        document.write("★");
        star1++;}
document.write("<br><br>");

/*var star=0;
while(star<=4){
    var star2=0;
    while(star2<=star){
        document.write("★");
        star2++;}
        document.write("<br>");
star++;}*/

var tate=1;
while(tate<=5){
    var yoko=0;
    while(yoko<=3){
        document.write("★");
        if(tate-yoko==1){
            document.write("<br>");
        yoko++;}
        tate++;
    }












