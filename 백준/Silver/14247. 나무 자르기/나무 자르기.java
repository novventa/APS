import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new Main().solution();
    }

    private void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        String[] tree = br.readLine().split(" ");
        String[] grow = br.readLine().split(" ");

        Tree[] treeArray = new Tree[count];
        for (int i = 0; i < count; i++) {
            int value = Integer.parseInt(tree[i]);
            int growValue = Integer.parseInt(grow[i]);
            Tree treeObject = new Tree(value, growValue);

            treeArray[i] = treeObject;
        }

        long result = 0;
        Arrays.sort(treeArray);

        for (int i = 0; i < count; i++) {
            treeArray[i].value += (treeArray[i].growValue * i);
        }
        for (int i = 0; i < count; i++) {
            result += treeArray[i].value;
            treeArray[i].value = 0;
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();

    }
}

class Tree implements Comparable<Tree> {
    int value;
    int growValue;

    public Tree(int value, int growValue) {
        this.value = value;
        this.growValue = growValue;
    }

    @Override
    public int compareTo(Tree arg0) {
        return this.growValue - arg0.growValue;
    }
}