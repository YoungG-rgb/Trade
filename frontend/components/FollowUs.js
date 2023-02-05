import React from 'react';

const FollowUs = () => {
    return (
        <div className='absolute top-[200px] left-[60px]'>
            <ul className='flex flex-col gap-[10px]'>
                <li className='cursor-pointer flex items-center justify-center drop-shadow-md transition hover:bg-red-700 hover:shadow-lg hover:shadow-red-700/50 hover:text-white bg-white rounded-[50%] w-[40px] h-[40px]'>
                    {/*<img className='w-[20px]' src="/icons/pinterest.svg" alt="pinterest"/>*/}
                    <span className='icon-pinterest text-[25px]'></span>
                </li>
                <li className='cursor-pointer flex items-center justify-center drop-shadow-md transition hover:bg-cyan-700 hover:shadow-lg hover:shadow-cyan-700/50 hover:text-white bg-white rounded-[50%] w-[40px] h-[40px]'>
                    {/*<img className='w-[15px]' src="/icons/facebook.svg" alt="facebook"/>*/}
                    <span className='icon-facebook text-[25px]'></span>
                </li>
                <li className='cursor-pointer flex items-center justify-center drop-shadow-md transition hover:bg-cyan-500 hover:shadow-lg hover:shadow-cyan-500/50 hover:text-white bg-white rounded-[50%] w-[40px] h-[40px]'>
                    {/*<img className='w-[20px]' src="/icons/twitter.svg" alt="twitter"/>*/}
                    <span className='icon-twitter text-[25px]'></span>
                </li>
                <li className='cursor-pointer flex items-center justify-center drop-shadow-md transition bg-instagram hover:text-white bg-white rounded-[50%] w-[40px] h-[40px]'>
                    <span className='icon-instagram text-[25px]'></span>
                </li>
                <li className='not-italic font-normal text-[14px] leading-[12px] tracking-[0.44em] text-black rotate-[-90deg] absolute bottom-[-70px] left-[-40px] w-[120px]'>Follow us</li>
            </ul>
        </div>
    );
};

export default FollowUs;