package com.example.contactmanagementandroid;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {

    private List<Contact> contactList;

    public ContactAdapter(List<Contact> contactList) {
        this.contactList = contactList;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_item, parent, false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        Contact contact = contactList.get(position);
        String fullName = contact.getFirstName() + " " + contact.getLastName();
        holder.fullName.setText(fullName);

        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), ContactDetailActivity.class);
            intent.putExtra("fullName", fullName);
            intent.putExtra("email", contact.getEmail());
            intent.putExtra("phone", contact.getPhone());
            intent.putExtra("address", contact.getAddress());
            view.getContext().startActivity(intent);
        });
    }


    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public static class ContactViewHolder extends RecyclerView.ViewHolder {
        public TextView fullName;

        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);
            fullName = itemView.findViewById(R.id.fullName);
        }
    }
}
