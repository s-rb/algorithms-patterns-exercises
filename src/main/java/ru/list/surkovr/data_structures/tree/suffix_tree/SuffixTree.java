package ru.list.surkovr.data_structures.tree.suffix_tree;

import java.util.ArrayList;
import java.util.List;

public class SuffixTree
{
    private String text;
    private ArrayList<Node> nodes;
    private Node root;

    public SuffixTree(String text)
    {
        this.text = text;
        nodes = new ArrayList<>();
    }

    private void build()
    {
        //TODO
    }

    private List<Integer> search(String query)
    {
        ArrayList<Integer> positions = new ArrayList<>();
        //TODO
        return positions;
    }
}