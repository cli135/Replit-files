// Original ~2016, updated ~2019
// found at
// https://www.khanacademy.org/computer-programming/flight-simulator/5631947972673536

/* This is a little experiment done to learn more about perspective projection. */
/* If you have any questions, feel free to ask me down below! */

/**Arrow keys for barrel rolls.**/

//TO DO:
//When not holding arrow key, slowly push velocity to 0.
//reset nauseaFactor at some point ^^

noStroke();//my good friend noStroke :)

var nauseaFactor = 0;
var accel = 0.000001;
var tiltFactor = 0;
var tiltAccel = 0.00001;
var rotator = 0;
var altitude = 64;

//variables used for projection
var pixels = [];//array of all pixels stored in obj format {x,y,z}
var fov =250;//FOV === field of view. Play with this!

//Creating the points and storing in 'pixels' array
for (var x = -250; x < 250; x+=50) {
    for (var z = -250; z < 250; z+=50) {
        pixels.push({x: x, y: altitude, z:z});
    }
}

var rotateZ3D = function (theta) {
    var cosTheta = cos(theta);
    var sinTheta = sin(theta);
    
    for (var i = 0; i < pixels.length; i++) {
        var node = pixels[i];
        var x = node.x;
        var y = node.y;
        
        node.x = x * cosTheta - y * sinTheta;
        node.y = y * cosTheta + x * sinTheta;
        
    }
};
var rotateX3D = function (theta) {
    var cosTheta = cos(theta);
    var sinTheta = sin(theta);
    
    for (var i = 0; i < pixels.length; i++) {
        var node = pixels[i];
        var y = node.y;
        var z = node.z;
        
        node.y = y * cosTheta - z * sinTheta;
        node.z = z * cosTheta + y * sinTheta;
        
    }
};
var rotateY3D = function (theta) {
    var cosTheta = cos(theta);
    var sinTheta = sin(theta);
    
    for (var i = 0; i < pixels.length; i++) {
        var node = pixels[i];
        var x = node.x;
        var z = node.z;
        
        node.x = x * cosTheta - z * sinTheta;
        node.z = z * cosTheta + x * sinTheta;
        
    }
};
//animation
draw = function() {
    
    background(255,255,255);
    fill(0, 0, 0);
    rect(199,100,2,20);
    //drawing the pixels
    for (var pixel = 0; pixel < 100; pixel++) {
        
        //3D to 2D formula:
        var Scale = fov/(fov+pixels[pixel].z);//to learn why we divide by z visit https://www.ocf.berkeley.edu/~horie/persp.txt
        var x2d = pixels[pixel].x*Scale+width/2;
        var y2d = pixels[pixel].y*Scale+height/2;
        
        //Only draw the point if it's on the screen
        if (x2d >= 0 && x2d < width && y2d > 0 && y2d < height) {
            fill(79, 214, 88);
                ellipse(x2d,y2d,4,4);
        }
        //If it's not on the screen, reset the zCoord so that it is
        else {
            pixels[pixel].z = fov;
        }
        
        //Begin moving the plane, and rotate the plane if needed
        pixels[pixel].z--;
        
        //rotateY3D(0.01);
        //rotateX3D(tiltFactor);
        //Accelerate or decelerate according to whether keys are pressed
        if (keyIsPressed && keyCode === LEFT) {
        nauseaFactor -= accel;
        }
        else if (keyIsPressed && keyCode === RIGHT) {
        nauseaFactor += accel;
        }
        rotateZ3D(nauseaFactor);
    }
    if (keyPressed && keyCode === DOWN) {
    println("Pilot command log opened on "+month()+ "/"+day()+"/"+ year()+" at "+hour()+":"+minute()+":"+second());
}
};
