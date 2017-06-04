public class Map{
    Mnode[][] map;
    int rows, cols;

    public Map(int rows, int cols){
	this.rows = rows;
	this.cols = cols;
	map = new Mnode[rows][cols];
	for(int i = 0; i < rows; i++){
	    for(int j = 0; j < cols; j++){
		map[i][j]= new Mnode( j/2, i, false);
	    }
	}
	for(int i = 0; i < rows; i++){
	    for(int j = 0; j < cols; j+=2){
		if(i&1 == 0 && j == 0){
		    j++;
		}
		map[i][j].walkable= true;
	    }
	}
    }

    public void obstacle(int x, int y){
	map[x][y].walkable = false;

    public void print(){
	for(int i = 0; i < rows; i++){
	    for(int j = 0; j < cols; j++){
		Mnode here = map[i][j];
		if(here.walkable == true){
		    System.out.print("("+here.x+","+here.y+")");
		}else if(i&1 == 0 && j == 0){
		    System.out.print("  ");
		}else{
		    System.out.print("");
		}
	    }
	    System.out.println();
	}
	for(int i = 0; i < rows; i++){
	    for(int j = 0; j< cols; j++){
		Mnode here = map[i][j];
		if(here.walkable == true){
		    System.out.print(1);
		}else{
		    System.out.print(" ");
		}
	    }
	    System.out.println();
	}
    }
    
    public static void main(String args[]){
	Map a = new Map(10,10);
	a.print();
    }
}
