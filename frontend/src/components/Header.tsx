import React from "react";
import './Header.css';
import {Link, NavLink} from "react-router-dom";

type Props = {
    user: string | undefined
}
export default function Header(props: Props) {
    const authenticated = props.user !== undefined && props.user !== 'anonymousUser'

    return (
        <header className="header">
            <img className="header_img" src="https://img.freepik.com/free-vector/funny-bread-cartoon-character_1308-107264.jpg?w=1380&t=st=1681897820~exp=1681898420~hmac=7ba2a374187245c9d263d2208ba54d3793dbce72187d399a6bbadf7177ca60f8" alt="header-logo"/>
            <h1 className="header_title">Yummy Recipe</h1>
            <div >
                {authenticated ? (
                    <div>
                        <Link className="headerLinkLe" to='/recipes'>All Recipes</Link>
                        <Link className="headerLinkRi"  to='/recipes/add'>Add Recipe</Link>
                    </div>
                ) : (
                    <NavLink className="headerNav" to='/login'>Login</NavLink>
                )}
            </div>

        </header>
    )
}