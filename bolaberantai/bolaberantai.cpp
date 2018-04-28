#include <iostream>
#include <string>
#include <sstream>
using namespace std;

// convert char 'A' - 'Z' menjadi integer 0 - 25
int charIndex(char c) {
	return (c - 'A');
}

// main program
int main () {

	// membaca barisan bola
	string barisanBola;
	getline(cin, barisanBola);

	// membaca kantong
	string strKantong;
	getline(cin, strKantong);

	// parsing kantong
	long kantong[26] = {0};
	if (strKantong.size() != 0) {
		size_t pos = 0;
		string token;
		while (pos != -1) {
		    pos = strKantong.find(",");
		    int idx = charIndex(strKantong[0]);
		    token = strKantong.substr(2, pos);
		    long nBola = stoi(token);
		    kantong[idx] = nBola;
		    strKantong.erase(0, pos + 1);
		}
	}

	// membaca input
	string inputStr;
	while (getline(cin, inputStr)) {

		// parsing input tiap line
		stringstream stream(inputStr);
		string token;
		string command[4] = {""};
		int i = 0;
		while (stream >> token) {
			if (i < 4) {
				command[i] = token;
				++i;
			}
		}

		// pemrosesan input tiap line
		if (command[0].compare("AMBIL") == 0) {
			// cek validitas perintah
			if (command[1].compare("") != 0 && command[2].compare("") == 0) {
				int idx = stoi(command[1]);
				if (idx < barisanBola.size() && idx >= 0) {
					++kantong[charIndex(barisanBola[idx])];
					barisanBola.erase(idx,1);
				}
			}
		} else if (command[0].compare("SELIP") == 0) {
			// cek validitas perintah
			if (command[2].compare("") != 0 && command[3].compare("") == 0) {
				char bola = command[1][0];
				int idx = stoi(command[2]);
				if (idx <= barisanBola.size() && kantong[charIndex(bola)] > 0) {
					barisanBola.insert(idx, string(1, bola));
					--kantong[charIndex(bola)];
				}
			}
		}
	}

	// output file
	cout << barisanBola << endl;
	bool isFirst = true;
	for (int i = 0 ; i < 25; ++ i) {
		if (kantong[i] !=0) {
			if (isFirst) {
				isFirst = false;
			} else {
				cout << ',';
			}
			cout << char(i + 'A') << ":" << kantong[i];
		}
	}
	cout << endl;
}