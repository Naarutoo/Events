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


public class EventDetailsFragment extends Fragment {
private EditText mEtEventTitle,mEtEventDescription;
private Button mBtnNextTime;
private CommunicationListner communicationListner;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
this.communicationListner = (CommunicationListner)context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_event_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull  View view, @Nullable  Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initviews(view);
    }

    private void initviews(View view) {
    mEtEventTitle = view.findViewById(R.id.etEventTitle);
    mEtEventDescription = view.findViewById(R.id.etEventDescription);
    mBtnNextTime = view.findViewById(R.id.btnNextTime);

    mBtnNextTime.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
      String EventTitle = mEtEventTitle.getText().toString();
      String EventDesc = mEtEventDescription.getText().toString();

      Bundle bundle = new Bundle();
      bundle.putString("EventTitle",EventTitle);
      bundle.putString("EventDesc",EventDesc);
      communicationListner.dataFromTimeDetails(bundle);
        }
    });
    }


}