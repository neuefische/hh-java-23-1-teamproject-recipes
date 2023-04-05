import {ChangeEventHandler} from "react";


type FormularProps = {
    enterName: string,
    onNameInputChange: ChangeEventHandler<HTMLInputElement>,
}

export default function Formular(props: FormularProps ){

    return(
        <div className="formular">
            <input className="formular-bar" placeholder={"Enter name"} value={props.enterName} onChange={props.onNameInputChange}/>
        </div>
    )
}