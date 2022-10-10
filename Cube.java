import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Cube {
	
  static String[][] rubiks = {{
      "r","r","r",
      "r","r","r",
      "r","r","r",
      },{
      "b","b","b",
      "b","b","b",
      "b","b","b",
      },{
      "o","o","o",
      "o","o","o",
      "o","o","o",
      },{
      "g","g","g",
      "g","g","g",
      "g","g","g",
      },{
      "y","y","y",
      "y","y","y",
      "y","y","y",
      },{
      "w","w","w",
      "w","w","w",
      "w","w","w",
      },
  };

  class edgedFace{
      public int current_face;
      int[] edge1 = new int[4];//index 0 is the face 1-3 are elements of the face [1,0,1,2]
      int[] edge2 = new int[4];//                                                 [0,0,1,2] 
      int[] edge3 = new int[4];
      int[] edge4 = new int[4];

      public edgedFace(int face){
        current_face = face;

        switch(face){
          case 0:
          edge1[0] = 1;
          edge1[1] = 2;
          edge1[2] = 5;
          edge1[3] = 8;

          edge2[0] = 4;
          edge2[1] = 2;
          edge2[2] = 5;
          edge2[3] = 8;

          edge3[0] = 3;
          edge3[1] = 0;
          edge3[2] = 3;
          edge3[3] = 6;

          edge4[0] = 5;
          edge4[1] = 2;
          edge4[2] = 5;
          edge4[3] = 8;
          break;
          case 1:
          edge1[0] = 1;
          edge1[1] = 2;
          edge1[2] = 5;
          edge1[3] = 8;

          edge2[0] = 4;
          edge2[1] = 2;
          edge2[2] = 5;
          edge2[3] = 8;

          edge3[0] = 3;
          edge3[1] = 0;
          edge3[2] = 3;
          edge3[3] = 6;

          edge4[0] = 5;
          edge4[1] = 2;
          edge4[2] = 5;
          edge4[3] = 8;
          break;
          case 2:
          edge1[0] = 1;
          edge1[1] = 2;
          edge1[2] = 5;
          edge1[3] = 8;

          edge2[0] = 4;
          edge2[1] = 2;
          edge2[2] = 5;
          edge2[3] = 8;

          edge3[0] = 3;
          edge3[1] = 0;
          edge3[2] = 3;
          edge3[3] = 6;

          edge4[0] = 5;
          edge4[1] = 2;
          edge4[2] = 5;
          edge4[3] = 8;
          break;
          case 3:
          edge1[0] = 1;
          edge1[1] = 2;
          edge1[2] = 5;
          edge1[3] = 8;

          edge2[0] = 4;
          edge2[1] = 2;
          edge2[2] = 5;
          edge2[3] = 8;

          edge3[0] = 3;
          edge3[1] = 0;
          edge3[2] = 3;
          edge3[3] = 6;

          edge4[0] = 5;
          edge4[1] = 2;
          edge4[2] = 5;
          edge4[3] = 8;
          break;
          case 4:
          edge1[0] = 1;
          edge1[1] = 2;
          edge1[2] = 5;
          edge1[3] = 8;

          edge2[0] = 4;
          edge2[1] = 2;
          edge2[2] = 5;
          edge2[3] = 8;

          edge3[0] = 3;
          edge3[1] = 0;
          edge3[2] = 3;
          edge3[3] = 6;

          edge4[0] = 5;
          edge4[1] = 2;
          edge4[2] = 5;
          edge4[3] = 8;
          break;
          case 5:
          edge1[0] = 1;
          edge1[1] = 2;
          edge1[2] = 5;
          edge1[3] = 8;

          edge2[0] = 4;
          edge2[1] = 2;
          edge2[2] = 5;
          edge2[3] = 8;

          edge3[0] = 3;
          edge3[1] = 0;
          edge3[2] = 3;
          edge3[3] = 6;

          edge4[0] = 5;
          edge4[1] = 2;
          edge4[2] = 5;
          edge4[3] = 8;
          break;
        }
    }

  }

  public void turnFace(int index, String direction){
      edgedFace eFace = new edgedFace(index);

      String[][] copy = new String[6][9];

      for(int i =0; i<6; i++){
          for(int j =0; j<9; i++){
              copy[i][j] = rubiks[i][j];
          }
      }

      switch(direction){
          case "c":
          rubiks[eFace.current_face][0] = copy[eFace.current_face][2];
          rubiks[eFace.current_face][1] = copy[eFace.current_face][5];
          rubiks[eFace.current_face][2] = copy[eFace.current_face][8];
          rubiks[eFace.current_face][3] = copy[eFace.current_face][1];
          rubiks[eFace.current_face][5] = copy[eFace.current_face][7];
          rubiks[eFace.current_face][6] = copy[eFace.current_face][0];
          rubiks[eFace.current_face][7] = copy[eFace.current_face][3];
          rubiks[eFace.current_face][8] = copy[eFace.current_face][6];

          //edge 1 changed
          rubiks[eFace.edge1[0]][eFace.edge1[1]] = copy[eFace.edge4[0]][eFace.edge4[1]];
          rubiks[eFace.edge1[0]][eFace.edge1[2]] = copy[eFace.edge4[0]][eFace.edge4[2]];
          rubiks[eFace.edge1[0]][eFace.edge1[3]] = copy[eFace.edge4[0]][eFace.edge4[3]];

          //edge 2 changed
          rubiks[eFace.edge2[0]][eFace.edge2[1]] = copy[eFace.edge1[0]][eFace.edge1[1]];
          rubiks[eFace.edge2[0]][eFace.edge2[2]] = copy[eFace.edge1[0]][eFace.edge1[2]];
          rubiks[eFace.edge2[0]][eFace.edge2[3]] = copy[eFace.edge1[0]][eFace.edge1[3]];

          //edge 3 changed
          rubiks[eFace.edge3[0]][eFace.edge3[1]] = copy[eFace.edge2[0]][eFace.edge2[1]];
          rubiks[eFace.edge3[0]][eFace.edge3[2]] = copy[eFace.edge2[0]][eFace.edge2[2]];
          rubiks[eFace.edge3[0]][eFace.edge3[3]] = copy[eFace.edge2[0]][eFace.edge2[3]];

          //edge 4 changed
          rubiks[eFace.edge4[0]][eFace.edge4[1]] = copy[eFace.edge3[0]][eFace.edge3[1]];
          rubiks[eFace.edge4[0]][eFace.edge4[2]] = copy[eFace.edge3[0]][eFace.edge3[2]];
          rubiks[eFace.edge4[0]][eFace.edge4[3]] = copy[eFace.edge3[0]][eFace.edge3[3]];

          break;
          case "cc":
          rubiks[eFace.current_face][0] = copy[eFace.current_face][1];
          rubiks[eFace.current_face][1] = copy[eFace.current_face][5];
          rubiks[eFace.current_face][2] = copy[eFace.current_face][8];
          rubiks[eFace.current_face][3] = copy[eFace.current_face][1];
          rubiks[eFace.current_face][5] = copy[eFace.current_face][7];
          rubiks[eFace.current_face][6] = copy[eFace.current_face][0];
          rubiks[eFace.current_face][7] = copy[eFace.current_face][3];
          rubiks[eFace.current_face][8] = copy[eFace.current_face][6];

          //edge 1 changed
          rubiks[eFace.edge1[0]][eFace.edge1[1]] = copy[eFace.edge2[0]][eFace.edge2[1]];
          rubiks[eFace.edge1[0]][eFace.edge1[2]] = copy[eFace.edge2[0]][eFace.edge2[2]];
          rubiks[eFace.edge1[0]][eFace.edge1[3]] = copy[eFace.edge2[0]][eFace.edge2[3]];

          //edge 2 changed
          rubiks[eFace.edge2[0]][eFace.edge2[1]] = copy[eFace.edge3[0]][eFace.edge3[1]];
          rubiks[eFace.edge2[0]][eFace.edge2[2]] = copy[eFace.edge3[0]][eFace.edge3[2]];
          rubiks[eFace.edge2[0]][eFace.edge2[3]] = copy[eFace.edge3[0]][eFace.edge3[3]];

          //edge 3 changed
          rubiks[eFace.edge3[0]][eFace.edge3[1]] = copy[eFace.edge4[0]][eFace.edge4[1]];
          rubiks[eFace.edge3[0]][eFace.edge3[2]] = copy[eFace.edge4[0]][eFace.edge4[2]];
          rubiks[eFace.edge3[0]][eFace.edge3[3]] = copy[eFace.edge4[0]][eFace.edge4[3]];

          //edge 4 changed
          rubiks[eFace.edge4[0]][eFace.edge4[1]] = copy[eFace.edge1[0]][eFace.edge1[1]];
          rubiks[eFace.edge4[0]][eFace.edge4[2]] = copy[eFace.edge1[0]][eFace.edge1[2]];
          rubiks[eFace.edge4[0]][eFace.edge4[3]] = copy[eFace.edge1[0]][eFace.edge1[3]];
          break;
      }

  }

  public void showCube(){
    for(int x=0; x<6; x++){
      for(int y=0; y<3; y++){
        for(int z=0; z<3; z++){
           System.out.print(rubiks[x][y+z]);

        }
        System.out.println();

      }
      System.out.println();
      
      }

  }

  public static void main(String[] args)
  throws IOException
  {

      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

      Cube RubiksCube =  new Cube();


      boolean argsCheck = false;
      int argsRunIndex = 0;

      if(args.length >  0){
          argsCheck = true;
      }

      boolean proceed  = true;

      while(proceed){
          String input;

          if(!argsCheck){
              input = reader.readLine();
          }else{
              if(argsRunIndex == args.length){
                  argsCheck = false;
                  input = "s";
              }else{
                  input = args[argsRunIndex];
                  argsRunIndex++;
              }

          }

          switch(input){
              case "u":
              RubiksCube.turnFace(4, "c");
              RubiksCube.showCube();
              break;
              case "d":
              RubiksCube.turnFace(3, "c");
              RubiksCube.showCube();
              break;
              case "r":
              RubiksCube.turnFace(0, "c");
              RubiksCube.showCube();
              break;
              case "l":
              RubiksCube.turnFace(5, "c");
              RubiksCube.showCube();
              break;
              case "f":
              RubiksCube.turnFace(1, "c");
              RubiksCube.showCube();
              break;
              case "b":
              RubiksCube.turnFace(2, "c");
              RubiksCube.showCube();
              break;
              case "u'":
              RubiksCube.turnFace(4, "cc");
              RubiksCube.showCube();
              break;
              case "d'":
              RubiksCube.turnFace(3, "cc");
              RubiksCube.showCube();
              break;
              case "r'":
              RubiksCube.turnFace(0, "cc");
              RubiksCube.showCube();
              break;
              case "l'":
              RubiksCube.turnFace(5, "cc");
              RubiksCube.showCube();
              break;
              case "f'":
              RubiksCube.turnFace(1, "cc");
              RubiksCube.showCube();
              break;
              case "b'":
              RubiksCube.turnFace(2, "cc");
              RubiksCube.showCube();
              break;
              case "s'":
              proceed = true;
              break;
              case "q'":
              proceed = false;
              break;
            }
        }

    }

}
