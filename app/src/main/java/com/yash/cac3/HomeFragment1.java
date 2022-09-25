package com.yash.cac3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HomeFragment1  extends Fragment implements PopupMenu.OnMenuItemClickListener {
    TextView t1;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
       t1 = getActivity().findViewById(R.id.textView5);
       t1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               showPopup(v);
           }
       });
    }

    private void showPopup(View view) {
        PopupMenu popmenu = new PopupMenu(getActivity().getApplicationContext(),view);
        popmenu.setOnMenuItemClickListener(this);
        popmenu.inflate(R.menu.pop_menu);
        popmenu.show();
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container , false);

    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                Toast.makeText(getActivity().getApplicationContext(), "Item1 selected", Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(getActivity().getApplicationContext(), "Default", Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}
