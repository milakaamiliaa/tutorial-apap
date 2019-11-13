import React from "react";
import Item from "./Item";

export default function List(props) {
    const styles = {
        heading : {
            fontFamily: "courier new"
        }
    };


    return(
        <>
        <h3 style={styles.heading}>{props.title}</h3>
        <div className="list-group">
            {props.items.map(item => (
                <Item key={item.id} item={item} onChange={props.onItemClick} inputType={props.inputType}/>
            ))}
        </div>
        </>
    );
}
