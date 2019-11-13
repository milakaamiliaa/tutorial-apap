import React from "react";

export default function EmptyState(props) {
    const styles = {
        heading : {
            fontFamily: "courier new"
        }
    };

    return(
        <>
            <h3 style={styles.heading}>{props.title}</h3>
            <div className="d-flex w-100 justify-content-center align-items-center row">
                <h4>Belum ada item yang dipilih</h4>
                <p>Klik salah satu item di daftar Menu/Produk</p>
            </div>
        </>
    )
}