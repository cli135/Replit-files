#include <iostream>
#include <vector>
#include <string>
#include <sstream>  // DO NOT FORGET THIS!!!
//https://www.cplusplus.com/reference/sstream/stringstream/
// great help
#include <fstream>

// SOURCE

// nevermind these helped the most
// using bash to do sed repeatedly

// sed -i 's/before/after/g' <filename>
// s stands for substitution
// /g stands for global (everywhere in file)
//https://stackoverflow.com/questions/13610639/tr-command-how-to-replace-the-string-n-with-an-actual-newline-n

// "$@" stands for all command line arguments
// we can do for i in "$@" and then use "$i" to access them
//https://stackoverflow.com/questions/55051851/how-to-use-a-for-loop-to-run-sed-i-on-multiple-files

// chmod +x <filename>
//https://www.javatpoint.com/steps-to-write-and-execute-a-shell-script

// https://www.geeksforgeeks.org/sed-command-in-linux-unix-with-examples/

// https://gist.github.com/zouzias/2ad84c6325e6c8a96e40eabe78e07170



/*
using namespace std;

int main() {
  vector<string> filenames;
  for (int i = 3; i <= 20; i++) {
    std::stringstream ss("");
    ss << "new " << i << ".txt";
    filenames.push_back(ss.str());
  }
  for (size_t i = 0; i < filenames.size(); i++) {
    // chk
    //cout << filenames[i] << endl;
    ifstream ifile(filenames[i]);
    ofstream ofile("out " + filenames[i]);

  }
}
*/