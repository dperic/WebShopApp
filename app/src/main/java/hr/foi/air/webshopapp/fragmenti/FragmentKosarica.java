package hr.foi.air.webshopapp.fragmenti;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import hr.foi.air.webshopapp.R;
import hr.foi.air.webshopapp.activity.MainActivity;
import hr.foi.air.webshopapp.dbmodule.dbOperations.OrderProducts;


public class FragmentKosarica extends Fragment implements View.OnClickListener{
    private Button btnOrder;
    SharedPreferences sharedPreferences;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ((MainActivity) getActivity()).setActionBarTitle(getString(R.string.title_kosarica));
        View rootView = inflater.inflate(R.layout.fragment_kosarica, container, false);

        btnOrder = (Button) rootView.findViewById(R.id.btnOrder);

        btnOrder.setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


    @Override
    public void onClick(View v) {
        sharedPreferences = getActivity().getSharedPreferences("SessionManager", 0);
        final String userName = sharedPreferences.getString("userNameKey", "").toString().trim();
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        OrderProducts orderProducts = new OrderProducts();
        orderProducts.saveUser(userName, requestQueue);
    }
}
