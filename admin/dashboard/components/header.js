import { CgProfile } from 'react-icons/si'

const Header = () => {
    return (
        <header>
            <div>
                <CgProfile />
            </div>
            <nav>
                <a>Dashboard</a>
                <a>Users</a>
                <a>Items</a>
                <a>Coupons</a>
            </nav>

        </header>
    )
}

export default Header;