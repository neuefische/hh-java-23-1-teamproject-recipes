import React from "react";
import {Link, NavLink} from "react-router-dom";

type Props = {
    user: string | undefined
}
export default function Header(props: Props) {
    const authenticated = props.user !== undefined && props.user !== 'anonymousUser'

    return (
        <header className="header">
            <h1 className="header_title">Rezepte</h1>
            <div>
                {authenticated ? (
<>
                        <Link className="headerLink" to='/recipes'>All Recipes</Link>
                        <Link className="headerNav" to='/recipes/add'>Add Recipe</Link>
                    </>
                ) : (
            <NavLink className="headerNav" to='/login'>Login</NavLink>)}
            </div>
        </header>
    )
}