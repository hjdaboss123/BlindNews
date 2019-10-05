package com.blindnews.kimh2.blindnews;


import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Nullable;

import static android.support.constraint.Constraints.TAG;



/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    class BlogPostSortByNewestFirst implements Comparator<BlogPost> {
        public int compare(BlogPost a, BlogPost b) {
            Date aa = a.getDateDate(); // i made up postedDate, replace that
            Date bb = b.getDateDate();
            return aa.compareTo(bb);
        }
    }

//    public static Iterable<DataSnapshot> reverse(Iterable<DataSnapshot> dataSnapshot) {
  //      int size = dataSnapshot.


    //    return dataSnapshot;
    //}

    private RecyclerView blog_list_view;
    private List<BlogPost> blog_list;
    //private FirebaseFirestore firebaseFirestore;
    private FirebaseDatabase firebaseDatabase;

    private BlogRecyclerAdapter blogRecyclerAdapter;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        blog_list = new ArrayList<>();
        blog_list_view = view.findViewById(R.id.blog_list_view);

        blogRecyclerAdapter = new BlogRecyclerAdapter(blog_list);
        blog_list_view.setLayoutManager(new LinearLayoutManager(container.getContext()));
        blog_list_view.setAdapter(blogRecyclerAdapter);

        firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = firebaseDatabase.getReference("articles");


        //finding the posts and posting it
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                //Iterable<DataSnapshot> snapShotIterator = dataSnapshot.getChildren();
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    blog_list.add(ds.getValue(BlogPost.class)); // i think? revisit that...
                }
                Collections.sort(blog_list, new BlogPostSortByNewestFirst()); // sorts newest first

               // sorts newest first
                //Log.d("HomeFragment", "onCreateView: " + blog_list.size());
                //Send updated list to adapter.
                blogRecyclerAdapter.updatePosts(blog_list);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w(TAG, "Failed to read value.", databaseError.toException());
            }
        });

        return view;
    }

}
