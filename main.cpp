#include <iostream>
#include <vector>
#include <string>
#include <sstream>  // DO NOT FORGET THIS!!!
//https://www.cplusplus.com/reference/sstream/stringstream/
// great help
#include <fstream>


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
    
    std::ofstream ofile(filenames[i]);

  
  }
}