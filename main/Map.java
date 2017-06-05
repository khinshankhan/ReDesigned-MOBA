public class Map{
    Mnode[][] map;
    int rows, cols;
    Mnode[][] map2;

    public Map(int rows, int cols){
	this.rows = rows;
	this.cols = cols;
	//map = new Mnode[rows][cols];
	map = new Mnode[rows][cols+cols*2-1];
	/*for(int i = 0; i < rows; i++){
	    for(int j = 0; j < cols; j++){
		map[i][j]= new Mnode( j/2, -i, false);
	    }
	}
	for(int i = 0; i < rows; i++){
	    for(int j = 0; j < cols; j+=2){
		int c = i & 1;
		if(c == 0 && j == 0){
		    j++;
		}
		map[i][j].walkable= true;
	    }
	    }*/
	for(int i = 0, k = cols*2-1, l = 0; i < rows; i++, k -= 2, l++){
	    for(int j = 0; j < cols+cols*2-1; j++){
		if(j > k){
		    map[i][j] = new Mnode(i, j-k, true);
		}else{
		    map[i][j] = null;
		}
	    }
	}
    }

    public void obstacle(int x, int y){
	map[x][y].walkable = false;
    }

    public void print(){
	for(int i = 0; i < rows; i++){
	    for(int j = 0; j < cols; j++){
		Mnode here = map[i][j];
		int c = i & 1;
		if(here == null){
		    System.out.print("  ");
		}else if(here.walkable == true){
		    System.out.print("("+here.x+","+here.y+")");
		}else{
		    System.out.print("");
		}
	    }
	    /*
	      if(here.walkable == true){
	      System.out.print("("+here.x+","+here.y+")");
	      }else if(c == 0 && j == 0){
	      System.out.print("  ");
	      }else{
	      System.out.print("");
	      }*/
	    System.out.println();
	}
	System.out.println();
	for(int i = 0; i < rows; i++){
	    for(int j = 0; j< cols; j++){
		Mnode here = map[i][j];
		if(here == null){
		    System.out.print(" ");
		}else if(here.walkable == true){
		    System.out.print(1);
		}else{
		    System.out.print(0);
		}
	    }
	    System.out.println();
	}
    }
    
    public static void main(String args[]){
	Map a = new Map(10,10);
	System.out.println();
	a.print();
    }
}
