package com.example.werkstuk_android;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class ListWithEntries {
    @Embedded public List list;
    @Relation(
            parentColumn = "userListId",
            entityColumn = "userListId"
    )
    public List<UserListEntry> entries;
}
