public class QuickUnionUF{
    private int id[];
    private int size[];
    public QuickUnionUF(int N){
        id = new int[N];
        size = new int[N];
        for (int i = 0; i < N; i++){
            id[i] = i;
            size[i] = 1;
        }
    }

    private int root(int i){
        while(i != id[i]){
            i = id[i];
        }
        return i;
    }

    public boolean find(int p, int q){
        return root[p] == root[q];
    }

    public void union(int p, int q){
        rootP = root(p);
        rootQ = root(q);
        if (rootP == rootQ) {
            return;
        }
        if (size[p] < size[q]){
            id[rootP] = rootQ;
            size[q] += size[p];
        } else {
            id[rootQ] = rootP;
            size[p] += size[q];
        }
    }
}
