package com.example.TreeView;

import com.example.Tally.TallyInterface;

public interface TreeViewInterface {
    public String getID();
    public String toString();
    public void accept(TallyInterface visitor);
}