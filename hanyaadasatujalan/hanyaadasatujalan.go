package main

import (
    "fmt"
    "bufio"
    "os"
)

func main() {

	// reading file
	reader := bufio.NewReader(os.Stdin)
    var m, n int
    fmt.Scan(&m, &n)

	var maps [101][101]rune
    
    i := 0
    for i < m {
    	j := 0
    	for j < n {
    		maps[i][j], _, _ = reader.ReadRune()
    		j ++
    	}
    	_,_,_ = reader.ReadRune()
    	i ++
    }

    // search S
    var x, y int
    notFound := true
    i = 0
    for i < m && notFound {
    	j := 0
    	for j < n && notFound {
    		if maps[i][j] == 'S' {
    			y = i
    			x = j
    			maps[i][j] = 'X'
    			notFound = false
    		}
    		j ++
    	}
    	i++
    }

    // search for a . or E near current x,y
    // if found, replace the . or E with 'X' and write the direction to console;
    // if E found, exit the loop
    notFinished := true
    for notFinished {
    	if x > 0 {
    		if maps[y][x-1] == '.' {
    			fmt.Printf("L")
    			x = x - 1
    			maps[y][x] = 'X'
    		} else if maps[y][x-1] == 'E' {
    			fmt.Printf("L")
    			x = x - 1
    			maps[y][x] = 'X'
    			notFinished = false
    		}
    	}
    	if x < n - 1 {
    		if maps[y][x+1] == '.' {
    			fmt.Printf("R")
    			x = x + 1
    			maps[y][x] = 'X'
    		} else if maps[y][x+1] == 'E' {
    			fmt.Printf("R")
    			x = x + 1
    			maps[y][x] = 'X'
    			notFinished = false
    		}
    	}
    	if y > 0 {
    		if maps[y-1][x] == '.' {
    			fmt.Printf("U")
    			y = y - 1
    			maps[y][x] = 'X'
    		} else if maps[y-1][x] == 'E' {
    			fmt.Printf("U")
    			y = y - 1
    			maps[y][x] = 'X'
    			notFinished = false
    		}
    	}
    	if y < m - 1 {
    		if maps[y+1][x] == '.' {
    			fmt.Printf("D")
    			y = y + 1
    			maps[y][x] = 'X'
    		} else if maps[y+1][x] == 'E' {
    			fmt.Printf("D")
    			y := y + 1
    			maps[y][x] = 'X'
    			notFinished = false
    		}
    	}
    }
    fmt.Printf("\n")

}