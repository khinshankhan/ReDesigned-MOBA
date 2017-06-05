public class Map{
    Mnode[][] map;
    int rows, cols;

    public Map(int rows, int cols){
	this.rows = rows;
	this.cols = cols;
	map = new Mnode[rows][cols * cols + cols -1];
	//System.out.println(cols * 2 -2);
	//System.out.println(map[0].length);
	for(int i = 0, k = cols * 2 -2; i < rows; i++, k -= 2){
	    for(int j = 0, h = 0; j < map[0].length ; j++, h++){
		if(j > k && j < map[0].length - i){
		    if(j - k == 1){
			j--;
		    }
		    map[i][j] = new Mnode(i, h - k - 1, true);
		    j+=3;
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
	    for(int j = 0; j < map[0].length; j++){
		Mnode here = map[i][j];
		//int c = i & 1;
		if(here == null){
		    System.out.print("     ");
		}else if(here.walkable == true){
		    System.out.print("("+here.x+","+here.y+")");
		}else{
		    System.out.print("");
		}
	    }
	    System.out.println();
	}
	System.out.println();
	for(int i = 0; i < rows; i++){
	    for(int j = 0; j < map[0].length; j++){
		Mnode here = map[i][j];
		if(here == null){
		    System.out.print(0);
		}else if(here.walkable == true){
		    System.out.print(1);
		}else{
		    System.out.print(2);
		}
	    }
	    System.out.println();
	}
    }
    
    public static void main(String args[]){
	Map a = new Map(5 ,5);
	System.out.println();
	a.print();
    }
}
