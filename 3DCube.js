// done around 2016, updated around 2020
// https://www.khanacademy.org/computer-programming/3-d-cube/4560289291960320
//Drag your mouse to move the cube

//translate();

//Colors!
var backgroundColor = color (255,255,255);
var nodeColor = color(255, 0, 0);
var edgeColor = color(214, 28, 214);

var s = 69;//Play with this!
var nodeSize = s/10;

//The nodes!
var node0 = [-s,-s,-s];
var node1 = [-s,-s,s];
var node2 = [-s,s,-s];
var node3 = [-s,s,s];
var node4 = [s,-s,-s];
var node5 = [s,-s,s];
var node6 = [s,s,-s];
var node7 = [s,s,s];
var nodes = [node0,node1,node2,node3,node4,node5,node6,node7];

//The edges!
var edge0 = [0,1];
var edge1 = [1,3];
var edge2 = [3,2];
var edge3 = [2,0];
var edge4 = [4,5];
var edge5 = [5,7];
var edge6 = [7,6];
var edge7 = [6,4];
var edge8 = [0,4];
var edge9 = [1,5];
var edge10 = [2,6];
var edge11 = [3,7];
var edges = [edge0,edge1,edge2,edge3,edge4,edge5,edge6,edge7,edge8,edge9,edge10,edge11];

var rotateZ3D = function (theta) {
    var sinTheta = sin(theta);
    var cosTheta = cos(theta);
    
    for (var z = 0; z < nodes.length; z++) {
        var currentNode = nodes[z];
        var xCoord = currentNode[0];
        var yCoord = currentNode[1];
        
        currentNode[0] = xCoord * cosTheta - yCoord * sinTheta;
        currentNode[1] = yCoord * cosTheta + xCoord * sinTheta;
    }
};
var rotateY3D = function (theta) {
    var sinTheta = sin(theta);
    var cosTheta = cos(theta);
    
    for (var y = 0; y < nodes.length; y++) {
        var currentNode = nodes[y];
        var xCoord = currentNode[0];
        var zCoord = currentNode [2];
        
        currentNode[0] = xCoord * cosTheta - zCoord * sinTheta;
        currentNode[2] = zCoord * cosTheta + xCoord * sinTheta;
    
    }
};
var rotateX3D = function (theta) {
    var sinTheta = sin(theta);
    var cosTheta = cos(theta);
    
    for (var x = 0; x < nodes.length; x++) {
        var currentNode = nodes[x];
        var yCoord = currentNode [1];
        var zCoord = currentNode [2];
        
        currentNode[1] = yCoord * cosTheta - zCoord * sinTheta;
        currentNode[2] = zCoord * cosTheta + yCoord * sinTheta;
    }
};

var draw = function() {
    
    translate(100,100);
    background(backgroundColor);
    
    //Drawing the edges :D
    stroke(edgeColor);
    for (var e = 0; e < edges.length; e++) {
        var nFirst = edges[e][0]; //Storing the node number value for the first node
        var nSecond = edges[e][1]; //Storing the node number value for the second node
        var firstNode = nodes[nFirst];//This is the first node/vertex of the current edge you're drawing
        var secondNode = nodes[nSecond];//This is the other node/vertex of the current edge you're drawing
        
        line(firstNode[0],firstNode[1],secondNode[0],secondNode[1]);//Drawing a line from the firstNode's x and y coordinates to the secondNode's x and y coordinates.
    }
    noStroke();
    fill(nodeColor);
    for (var n = 0; n < nodes.length; n++) {
        var currentNode = nodes[n];
        var xCoord = currentNode[0];
        var yCoord = currentNode[1];
    
        ellipse(xCoord,yCoord,nodeSize,nodeSize);
        fill(255, 0, 0);
    
    }
for (var t = 0; t < nodes.length; t++) {
    fill(255, 0, 0);
    text(t,nodes[t][0]+13,nodes[t][1]+4);
}
};

/*
rotateZ3D(44);
rotateY3D(112);
rotateX3D(339);
*/
mouseDragged = function () {
    rotateY3D(mouseX - pmouseX);
    rotateX3D(mouseY - pmouseY);
};
