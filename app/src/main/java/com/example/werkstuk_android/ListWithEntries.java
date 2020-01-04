package com.example.werkstuk_android;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class ListWithEntries {

    public ListWithEntries(){}

    @Embedded public UserList list;
    @Relation(
            parentColumn = "userListId",
            entityColumn = "userListId"
    )
    public List<UserListEntry> entries;
}
