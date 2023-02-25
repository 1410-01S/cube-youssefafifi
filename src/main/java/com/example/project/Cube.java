public class RubiksCube {

    private char[][][] cube = new char[3][3][3];
    
    // Constructor that initializes the cube with default colors
    public RubiksCube() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    if (i == 0) {
                        cube[i][j][k] = 'W'; // White
                    } else if (i == 1) {
                        cube[i][j][k] = 'R'; // Red
                    } else if (i == 2) {
                        cube[i][j][k] = 'B'; // Blue
                    }
                }
            }
        }
    }

    //movements as well
    static void move(String[][][] Cube, String input){
        switch(input.toLowerCase()){
            case "u":
                soultion_stack.add("u'");
                rotateTop();
                break;
            case "d":
            soultion_stack.add("d'");
                rotateBottom();
                break;
            case "r":
            soultion_stack.add("r'");
                rotateRight();
                break;
            case "l":
            soultion_stack.add("l'");
                rotateLeft();
                break;
            case "f":
            soultion_stack.add("f'");
                rotateFront();
                break;
            case "b":
            soultion_stack.add("b'");
                rotateback();
                break;
            case "q":
            proceed = false;
                break;
            default:

        }
    }
    // Function to print the current state of the cube
    public void printCube() {
        for (int i = 0; i < 3; i++) {
            System.out.print("      ");
            for (int j = 0; j < 3; j++) {
                System.out.print(cube[0][i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(cube[4][i][j] + " ");
            }
            System.out.print(" ");
            for (int j = 0; j < 3; j++) {
                System.out.print(cube[1][i][j] + " ");
            }
            System.out.print(" ");
            for (int j = 0; j < 3; j++) {
                System.out.print(cube[2][i][j] + " ");
            }
            System.out.print(" ");
            for (int j = 0; j < 3; j++) {
                System.out.print(cube[3][i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        for (int i = 0; i < 3; i++) {
            System.out.print("      ");
            for (int j = 0; j < 3; j++) {
                System.out.print(cube[5][i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // Function to rotate the top face clockwise
    public void rotateTop() {
        char[][] temp = new char[3][3];
        // Store the current state of the face to be rotated
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                temp[i][j] = cube[0][i][j];
            }
        }
        // Rotate the face clockwise
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cube[0][i][j] = temp[2-j][i];
            }
        }
        // Rotate the adjacent sides as well
        char temp1 = cube[1][0][0];
        char temp2 = cube[1][0][1];
        char temp3 = cube[1][0][2];
        cube[1][0][0] = cube[2][0][0];
        cube[1][0][1] = cube[2][0][1];
        cube[1][0][2] = cube[2][0][2];
        cube[2][0][0] = cube[3][0][0];
        cube[2][0][1] = cube[3][0][1];
        cube[2][0][2] = cube[3][0][2];
        cube[3][0][0] = cube[4][0][0];
        cube[3][0][1] = cube[4][0][1];
        cube[3][0][2] = cube[4][0][2];
        cube[4][0][0] = temp1;
        cube[4][0][1] = temp2;
        cube[4][0][2] = temp3;
    }
    
    // Function to rotate the top face counter-clockwise
    public void rotateTopInverse() {
        rotateTop();
        rotateTop();
        rotateTop();
    }

    // Function to rotate the bottom face clockwise
    public void rotateBottom() {
        char[][] temp = new char[3][3];
        // Store the current state of the face to be rotated
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                temp[i][j] = cube[2][i][j];
            }
        }
        // Rotate the face clockwise
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cube[2][i][j] = temp[2-j][i];
            }
        }
        // Rotate the adjacent sides as well
        char temp1 = cube[1][2][0];
        char temp2 = cube[1][2][1];
        char temp3 = cube[1][2][2];
        cube[1][2][0] = cube[4][2][0];
        cube[1][2][1] = cube[4][2][1];
        cube[1][2][2] = cube[4][2][2];
        cube[4][2][0] = cube[3][2][0];
        cube[4][2][1] = cube[3][2][1];
        cube[4][2][2] = cube[3][2][2];
        cube[3][2][0] = cube[2][2][0];
        cube[3][2][1] = cube[2][2][1];
        cube[3][2][2] = cube[2][2][2];
        cube[2][2][0] = temp1;
        cube[2][2][1] = temp2;
        cube[2][2][2] = temp3;
    }
    
    // Function to rotate the bottom face counter-clockwise
    public void rotateBottomInverse() {
        rotateBottom();
        rotateBottom();
        rotateBottom();
    }

    // Function to rotate the left face clockwise
    public void rotateLeft() {
        char[][] temp = new char[3][3];
        // Store the current state of the face to be rotated
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                temp[i][j] = cube[0][i][j];
            }
        }
        // Rotate the face clockwise
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cube[0][i][j] = temp[j][2-i];
            }
        }
        // Rotate the adjacent sides as well
        char temp1 = cube[2][0][0];
        char temp2 = cube[2][0][1];
        char temp3 = cube[2][0][2];
        cube[2][0][0] = cube[1][0][0];
        cube[2][0][1] = cube[1][1][0];
        cube[2][0][2] = cube[1][2][0];
        cube[1][0][0] = cube[4][0][2];
        cube[1][1][0] = cube[4][1][2];
        cube[1][2][0] = cube[4][2][2];
        cube[4][0][2] = cube[3][2][0];
        cube[4][1][2] = cube[3][1][0];
        cube[4][2][2] = cube[3][0][0];
        cube[3][2][0] = temp1;
        cube[3][1][0] = temp2;
        cube[3][0][0] = temp3;
    }

    // Function to rotate the left face counter-clockwise
    public void rotateLeftInverse() {
        rotateLeft();
        rotateLeft();
        rotateLeft();
    }
    
    // Function to rotate the right face clockwise
    public void rotateRight() {
        char[][] temp = new char[3][3];
        // Store the current state of the face to be rotated
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                temp[i][j] = cube[i][j][2];
            }
        }
        // Rotate the face clockwise
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cube[i][j][2] = temp[j][2-i];
            }
        }
        // Rotate the adjacent sides as well
        char temp1 = cube[0][0][1];
        char temp2 = cube[0][1][1];
        char temp3 = cube[0][2][1];
        cube[0][0][1] = cube[5][0][1];
        cube[0][1][1] = cube[5][1][1];
        cube[0][2][1] = cube[5][2][1];
        cube[5][0][1] = cube[2][2][1];
        cube[5][1][1] = cube[2][1][1];
        cube[5][2][1] = cube[2][0][1];
        cube[2][2][1] = cube[4][0][0];
        cube[2][1][1] = cube[4][1][0];
        cube[2][0][1] = cube[4][2][0];
        cube[4][0][0] = temp1;
        cube[4][1][0] = temp2;
        cube[4][2][0] = temp3;
    }
    
    // Function to rotate the right face counter-clockwise
    public void rotateRightInverse() {
        rotateRight();
        rotateRight();
        rotateRight();
    }

    // Function to rotate the front face clockwise
    public void rotateFront() {
        char[][] temp = new char[3][3];
        // Store the current state of the face to be rotated
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                temp[i][j] = cube[1][i][j];
            }
        }
        // Rotate the face clockwise
        for (int i = 0; i < 3; i++) {
            cube[1][0][i] = temp[2-i][0];
            cube[1][1][i] = temp[2-i][1];
            cube[1][2][i] = temp[2-i][2];
        }
        // Rotate the adjacent sides as well
        char temp1 = cube[0][2][0];
        char temp2 = cube[0][2][1];
        char temp3 = cube[0][2][2];
        cube[0][2][0] = cube[4][0][2];
        cube[0][2][1] = cube[4][1][2];
        cube[0][2][2] = cube[4][2][2];
        cube[4][0][2] = cube[2][0][0];
        cube[4][1][2] = cube[2][0][1];
        cube[4][2][2] = cube[2][0][2];
        cube[2][0][0] = cube[5][2][0];
        cube[2][0][1] = cube[5][1][0];
        cube[2][0][2] = cube[5][0][0];
        cube[5][2][0] = temp1;
        cube[5][1][0] = temp2;
        cube[5][0][0] = temp3;
    }

    // Function to rotate the front face counter-clockwise
    public void rotateFrontInverse() {
        rotateFront();
        rotateFront();
        rotateFront();
    }
    
    // Function to rotate the back face clockwise
    public void rotateBack() {
        char[][] temp = new char[3][3];
        // Store the current state of the face to be rotated
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                temp[i][j] = cube[1][i][j];
            }
        }
        // Rotate the face clockwise
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cube[1][i][j] = temp[j][2-i];
            }
        }
        // Rotate the adjacent sides as well
        char temp1 = cube[2][2][0];
        char temp2 = cube[2][1][0];
        char temp3 = cube[2][0][0];
        cube[2][2][0] = cube[4][2][0];
        cube[2][1][0] = cube[4][1][0];
        cube[2][0][0] = cube[4][0][0];
        cube[4][2][0] = cube[5][2][2];
        cube[4][1][0] = cube[5][2][1];
        cube[4][0][0] = cube[5][2][0];
        cube[5][2][2] = cube[3][0][2];
        cube[5][2][1] = cube[3][1][2];
        cube[5][2][0] = cube[3][2][2];
        cube[3][0][2] = temp1;
        cube[3][1][2] = temp2;
        cube[3][2][2] = temp3;
    }
    
    // Function to rotate the back face counter-clockwise
    public void rotateBackInverse() {
        rotateBack();
        rotateBack();
        rotateBack();
    }

}
