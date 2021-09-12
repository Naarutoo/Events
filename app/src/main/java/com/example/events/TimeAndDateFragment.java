package com.example.events;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class TimeAndDateFragment extends Fragment {
    private Button mBtnNextPricePage;
    private EditText mEtStartDate, mEtEndDate, mEtStartTime, mEtEndTime;
    private CommunicationListner communicationListner;
    private String title, description;

    @Override
    public void onAttach(@NonNull  Context context) {
        super.onAttach(context);
        this.communicationListner = (CommunicationListner)context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
if (getArguments()!=null){
    title = getArguments().getString("EventTitle");
    description =getArguments().getString("EventDesc");
}
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_time_and_date, container, false);
    }

    @Override
    public void onViewCreated(@NonNull  View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
   initviews(view);
    }

    private void initviews(View view) {
   mEtStartDate = view.findViewById(R.id.etEventStartDate);
   mEtEndDate = view.findViewById(R.id.etEventEndDate);
   mEtStartTime = view.findViewById(R.id.etEventStartTime);
   mEtEndTime = view.findViewById(R.id.etEventEndTime);
   mBtnNextPricePage = view.findViewById(R.id.btnNextPrise);
   mBtnNextPricePage.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
String startDate = mEtStartDate.getText().toString();
String endDate = mEtEndDate.getText().toString();
String startTime = mEtStartTime.getText().toString();
String endTime = mEtEndTime.getText().toString();

Bundle bundle = new Bundle();
bundle.putString("title",title);
bundle.putString("description",description);
bundle.putString("startDate",startDate);
bundle.putString("endDate",endDate);
bundle.putString("startTime",startTime);
bundle.putString("endTime",endTime);
communicationListner.dataFromPricePage(bundle);
       }
   });
    }


}