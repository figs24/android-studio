<?php
require("koneksi.php");
$response=array();
if($_SERVER['REQUEST_METHOD']=='POST'){
    $id=$_POST["id"];

    $perintah="DELETE FROM laundry WHERE id='$id'";
    $eksekusi=mysqli_query($konek,$perintah);
    $cek=mysqli_affected_rows($konek);
    if($cek > 0){
        $response["kode"]=1;
        $response["pesan"]="Data Berhasil dihapus";

    }
    else{
        $response["kode"]=0;
        $response["pesan"]="Data Gagal dihapus";

    }
}
else{
    $response["kode"]=0;
    $response["pesan"]="Tidak Ada Post Data";

}
echo json_encode($response);
mysqli_close($konek);