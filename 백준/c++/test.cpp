#include <iostream>
#include <sstream>
using namespace std;

int main() {
  char *strHexValue = "' or '1'='1";
  unsigned int nHexValue;
  
  // String to Hex
  stringstream convert(strHexValue);
  convert >> std::hex >> nHexValue;
  cout << std::hex << nHexValue << endl;

  // Hex to String
  stringstream convert_invert;
  convert_invert << std::hex << nHexValue;
  cout << convert_invert.str() << endl;

  return 0;
}