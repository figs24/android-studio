<?php
require("koneksi.php");
$response=array();
if($_SERVER['REQUEST_METHOD']=='POST'){
    $id=$_POST["id"];
    $nama=$_POST["nama"];
    $alamat=$_POST["alamat"];
    $nohp=$_POST["nohp"];
    $kota=$_POST["kota"];

    $perintah="UPDATE laundry SET nama='$nama',alamat='$alamat',nohp='$nohp',kota='$kota' WHERE id='$id'";
    $eksekusi=mysqli_query($konek,$perintah);
    $cek=mysqli_affected_rows($konek);
    if($cek > 0){
        $response["kode"]=1;
        $response["pesan"]="Data berhasil diubah";
    }
    else{
        $response["kode"]=0;
        $response["pesan"]="Data Gagal diubah";
    }
}
else{
    $response["kode"]=0;
    $response["pesan"]="Tidak Ada Post Data";

}
echo json_encode($response);
mysqli_close($konek);