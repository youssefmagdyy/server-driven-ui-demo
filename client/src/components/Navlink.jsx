import "../styles/Navbar.css";

const Navlink = ({url,label}) => {
  return (
    <a href={url} className="nav-link">
      {label}
    </a>
  );
};

export default Navlink;
