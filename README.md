# ALIEF SYIHAN SP
# BELLA SETYOWATI

## BREAKOUT 5

### MainActivity.java
public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private final String TAG = Hasil.class.getName();
    public static final String Key_HasilActivity = "Key_HasilActivity";

    private EditText nama, nim, edtLahir;
    RadioGroup listJk;
    Button simpan, simpanPar;
    private Spinner jurusan;
    TextView lhr;
    RadioButton radioButtonJK;
    Calendar lahir;
    DatePickerDialog.OnDateSetListener date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nama = (EditText) findViewById(R.id.edtNama);
        nim = (EditText) findViewById(R.id.edtNim);
        edtLahir = (EditText) findViewById(R.id.edtTanggalLahir);
        final TextView tglLahir = findViewById(R.id.edtTanggalLahir);
        jurusan = (Spinner) findViewById(R.id.spinnerJurusan);
        listJk = (RadioGroup) findViewById(R.id.radioGroup);
        simpan = (Button) findViewById(R.id.btSimpan);
        simpanPar = (Button) findViewById(R.id.btnSimpanP);

        simpan.setOnClickListener(MainActivity.this);
        simpanPar.setOnClickListener(MainActivity.this);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.jurusan, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        jurusan.setAdapter(adapter);

        lhr = tglLahir;

        lahir = Calendar.getInstance();

        //jurusan.setOnItemSelectedListener(new ItemJurusan());        lahir = Calendar.getInstance();
        date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                lahir.set(Calendar.YEAR, year);
                lahir.set(Calendar.MONTH, month);
                lahir.set(Calendar.DAY_OF_MONTH, day);

                String format = "dd-MM-yyyy";
                SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.US);
                tglLahir.setText(sdf.format(lahir.getTime()));
            }
        };

        edtLahir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(MainActivity.this, date,
                        lahir.get(Calendar.YEAR),
                        lahir.get(Calendar.MONTH),
                        lahir.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btSimpan :
                // mengirim data menggunakan bundle dan intent
                int id = listJk.getCheckedRadioButtonId();
                Bundle bundle = new Bundle();
                bundle.putString("nama", nama.getText().toString());
                bundle.putString("nim", String.valueOf(nim.getText()));
                bundle.putString("lahir", String.valueOf(lhr.getText()));

                switch (id){
                    case R.id.btLaki :
                        bundle.putString("jk", (String) ((RadioButton)findViewById(R.id.btLaki)).getText().toString());
                        break;
                    case R.id.btPerempuan :
                        bundle.putString("jk", (String) ((RadioButton)findViewById(R.id.btPerempuan)).getText().toString());
                        break;
                }
                bundle.putString("jurusan", String.valueOf(jurusan.getSelectedItem()));
                Intent i = new Intent(MainActivity.this, Hasil.class);
                i.putExtras(bundle);
                startActivity(i);
            break;

            case R.id.btnSimpanP:
                //Mengirim data menggunakan parcelable
                String pNama = nama.getText().toString();
                String pNim = nim.getText().toString();
                String pLahir = lhr.getText().toString();

                int selectedJK = listJk.getCheckedRadioButtonId();
                radioButtonJK = findViewById(selectedJK);

                String pJk = radioButtonJK.getText().toString();

                String pJurusan = jurusan.getSelectedItem().toString();

                Biodata bio = new Biodata(pNama, pNim, pLahir, pJk, pJurusan);

                Intent ii = new Intent(MainActivity.this, Hasil.class);
                ii.putExtra(Hasil.Key_HasilActivity, bio);
                startActivity(ii);
            break;
        }
    }
}
